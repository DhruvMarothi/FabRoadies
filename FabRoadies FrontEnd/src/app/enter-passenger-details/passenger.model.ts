export class Passenger{
    public name: string='';
    public gender: string='';
    public age: number=0;
    public seatno: string = "";

    constructor(name: string,gender: string,age: number,seatno: string) {
        this.name= name;
        this.gender = gender;
        this.age = age;
        this.seatno = seatno;
    }

}