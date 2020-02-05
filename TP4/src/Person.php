<?php

namespace src;

use InvalidArgumentException;

class Person
{
    // Attributes
    public $lastName;
    public $firstName;
    public $birthDate;
    public $size;
    public $gender;
    public $leg = 2;
    public $foot = 2;

    // Const
    const ARMS_NUMBER = 2;
    const EYES_NUMBER = 2;
    const HANDS_NUMBER = 2;

    // Methods
    public function __construct($a1)
    {
        $this->lastName = $a1;
    }

    public function drink()
    {
        echo 'The person drinks.<br/>';
    }

    public function eat()
    {
        echo 'The person eats.<br/>';
    }

    public function walk()
    {
        if ($this->foot == 2) echo 'The person walks.';
        else throw new InvalidArgumentException('Too many feet !');
    }


    public function irradiate()
    {
        if ($this->foot < 5) {
            $this->foot++;
            $this->leg++;
        }
    }
}
