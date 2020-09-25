import {Value} from "./Value";

export class Field {
    ID : number;
    Name : string;
    ParentID : number;
    Expanded : boolean;
    Level : number;
    Field : string;
    Values : Value[];


    constructor(ID: number, Name: string, ParentID: number, Expanded: boolean, Level: number, Field: string, Values: Value[]) {
        this.ID = ID;
        this.Name = Name;
        this.ParentID = ParentID;
        this.Expanded = Expanded;
        this.Level = Level;
        this.Field = Field;
        this.Values = Values;
    }
}