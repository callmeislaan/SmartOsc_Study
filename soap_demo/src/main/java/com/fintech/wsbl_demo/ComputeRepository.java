package com.fintech.wsbl_demo;

import com.fintech.GetMinusResponse;
import com.fintech.GetPlusResponse;
import com.fintech.Numbers;
import org.springframework.stereotype.Repository;

@Repository
public class ComputeRepository {
    public GetPlusResponse plus(Numbers numbers) {
        GetPlusResponse getPlusResponse = new GetPlusResponse();
        getPlusResponse.setResult(numbers.getNumber1().intValue() + numbers.getNumber2().intValue());
        return getPlusResponse;
    }

    public GetMinusResponse minus(Numbers numbers) {
        GetMinusResponse getMinusResponse = new GetMinusResponse();
        getMinusResponse.setResult(numbers.getNumber1().intValue() - numbers.getNumber2().intValue());
        return getMinusResponse;
    }
}
