package io.dowlath.springbootunittesting;

import io.dowlath.springbootunittesting.data.SomeDataService;

/**
 * @Author Dowlath
 * @create 7/14/2020 8:42 PM
 */
public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        int sum=0;
        for(int value : data){
            sum+=value;
        }
        return sum;
    }

    public int calculateSumUsingDataService(){
        int sum=0;
        int[] data = someDataService.retrieveAllData();
        for(int value : data){
            sum+=value;
        }
        return sum;
    }
}
