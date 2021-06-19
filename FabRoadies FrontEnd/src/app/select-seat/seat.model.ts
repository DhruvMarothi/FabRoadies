//@Author : Jaspreet
// Model seat class for booking and ticket generation
export class seat {
    
    public seatno! : string ;
    public price! : number;

    constructor( seatno : string, price : number) {
        this.seatno = seatno;
        this.price = price;
    }

}