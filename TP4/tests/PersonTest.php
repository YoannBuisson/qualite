<?php
namespace tests;

use InvalidArgumentException;
use PHPUnit\Framework\TestCase;
use src\Person;

require_once('../src/Person.php');

class PersonTest extends TestCase
{
    private $person;

    protected function setUp()
    {
        parent::setUp();
        $this->person = new Person("Miguel");
    }

    public function testIrradiateShouldNowHaveThreeFeet()
    {
        $this->person->irradiate();
        $this->assertEquals(3, $this->person->foot);

    }

    /**
     * @depends testIrradiateShouldNowHaveThreeFeet
     */
    public function testIrradiateShouldNowHaveThreeLegs()
    {
        $this->person->irradiate();
        $this->assertEquals(3, $this->person->leg);
    }

    /**
     * @param $feetValue
     * @param $expectedLegs
     * @param $expectedFeet
     * @dataProvider irradiateProvider
     */
    public function testIrradiateForVariousNumberOfFeet($feetValue, $expectedLegs, $expectedFeet)
    {
        $this->person->foot = $feetValue;
        $this->person->irradiate();
        $this->assertEquals($expectedFeet, $this->person->foot);
        $this->assertEquals($expectedLegs, $this->person->leg);
    }

    public function irradiateProvider()
    {
        return [
            [2, 3, 3],
            [3, 3, 4],
            [5, 2, 5]
        ];
    }

    /**
     * @expectedException InvalidArgumentException
     * @expectedExceptionMessage Too many feet !
     */
    public function testWalkException()
    {
        $this->person->foot = 5;
        $this->person->walk();
    }

    public function testEatMessage() {
        $this->expectOutputString('The person eats.<br/>');
        $this->person->eat();
    }
}
