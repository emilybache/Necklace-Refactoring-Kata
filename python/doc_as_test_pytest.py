import json
import os
import pytest
from approvaltests.pytest.py_test_namer import PyTestNamer
from approvaltests.approvals import verify



@pytest.fixture(scope="function")
def doc(request, doc_module):
    yield doc_module

    doc_module.verify_function(request)

@pytest.fixture(scope="module")
def doc_module(request):
    doc = DocAsTest()

    yield doc

    doc.verify_module(request)

class DocAsTest():
    def __init__(self):
        self.content = ""
        self.tests = []

    def format_to_title(self, name):
        title = name[len("test_"):]
        title = title.replace("_", " ")
        title = title[0].upper() + title[1:]
        return title

    def module_content(self, request, description):
        file_base_name = os.path.splitext(os.path.basename(request.node.name))[0]
        title = self.format_to_title(file_base_name)

        includes = "\n".join("include::{}[leveloffset=+1]".format(test) for test in self.tests)
        
        description_to_add = description.strip() + "\n\n" if description is not None else ""

        return "= " + title + "\n" + description_to_add + includes

    def test_content(self, request, description):

        title = self.format_to_title(request.node.name)
        title = "= " + title +"\n\n"

        description = description.strip() +"\n\n" if description != None else ""

        return  title + description + self.content
            

    def register_test(self, namer):
        self.tests.append(namer.get_approved_filename(namer.get_file_name()))

    def write(self, text):
        self.content = self.content + text


    def verify_function(self, request):
       
        namer = DocAsTestFunctionNamer(request)

        class_name = namer.get_class_name()
        test_name = namer.get_method_name()
        
        test_module = __import__(class_name)
        description = getattr(test_module, test_name).__doc__

        self.register_test(namer)
        content_to_verify = self.test_content(request, description)
        self.content = ""
        verify(
            content_to_verify, 
            namer=namer
        )

    def verify_module(self, request):
        namer = DocAsTestModuleNamer(request)

        class_name = namer.get_class_name()
        test_module = __import__(class_name)
        description = test_module.__doc__

        verify(
            self.module_content(request, description), 
            namer = namer
        )

class DocAsTestNamer(PyTestNamer):
    Directory = ''
    MethodName = ''
    ClassName = ''
    
    def __init__(self, request):
        PyTestNamer.__init__(self, ".adoc")
        self.config = None
        self.MethodName = request.node.name
        self.ClassName = os.path.splitext(request.fspath.basename)[0]
        self.Directory = request.fspath.dirname
        
    def get_class_name(self):
        return self.ClassName
    
    def get_method_name(self):
        return self.MethodName
    
    def get_directory(self):
        return self.Directory
        #return os.path.join(self.Directory, "docs")

    def config_directory(self):
        return self.Directory
    
    def get_config(self):
        """lazy load config when we need it, then store it in the instance variable self.config"""
        if self.config is None:
             config_file = os.path.join(self.config_directory(), 'approvaltests_config.json')
             if os.path.exists(config_file):
                 with open(config_file, 'r') as f:
                     self.config = json.load(f)
             else:
                 self.config = {}
        return self.config


class DocAsTestFunctionNamer(DocAsTestNamer):
    
    def get_file_name(self):
        class_name = "" if (self.ClassName is None) else (self.ClassName + ".")
        return class_name + self.MethodName


class DocAsTestModuleNamer(DocAsTestNamer):
    
    def get_file_name(self):
        return self.ClassName
