export class bookreq {
    public userid : number=0;     
    public seatno : string = '';
    public busno : string = '';
    public name : string = '';
    public gender : string = '';
    public age : number = 0;
    public email : string = '';
    public phone : string = '';

    constructor( userid : number, seatno : string, busno : string, name : string, gender : string, age : number, email : string, phone : string){
        this.userid=userid;     
        this.seatno= seatno;
        this.busno= busno;
        this.name= name;
        this.gender= gender;
        this.age = age;
        this.email= email;
        this.phone= phone;
    }
}