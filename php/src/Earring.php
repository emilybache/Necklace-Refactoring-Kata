<?php

namespace NecklaceRefactoringKata;

enum EarringType {
    case Stud;
    case Hoop;
    case Drop;
}

class Earring extends Jewellery
{
    public function __construct(public EarringType $type)
    {
    }

    public function isSmall(): bool
    {
        return $this->type === EarringType::Stud;
    }

    public function isEarring(): bool
    {
        return true;
    }
}

