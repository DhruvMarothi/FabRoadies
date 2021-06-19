import { Ticket } from "./Ticket.model";

export class Passenger{
 id:number=0;
 seatno:number=0;
 name:string='';
 gender:string="";
 age:number=0;
 ticket:Ticket=new Ticket;
}