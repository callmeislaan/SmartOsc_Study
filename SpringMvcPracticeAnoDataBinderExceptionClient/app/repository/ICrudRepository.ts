export interface ICrudRepository <T, K> {
    getAll() : T[];
    getById(k : K) : T;
}