export class Value {
    Period : string;
    Year : number;
    Quarter : number;
    Value : number;


    constructor(Period: string, Year: number, Quarter: number, Value: number) {
        this.Period = Period;
        this.Year = Year;
        this.Quarter = Quarter;
        this.Value = Value;
    }
}