<?php

namespace NecklaceRefactoringKata;

enum EarringType {
    case Stud;
    case Hoop;
    case Drop;
}

class Earring extends Jewellery
{
    public function __construct(private EarringType $earringType)
    {
    }

    public function isSmall(): bool
    {
        return $this->earringType === EarringType::Stud;
    }

    public function isEarring(): bool
    {
        return true;
    }
}

