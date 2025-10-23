package com.example.servingwebcontent.Model;

public class myGlobal {
    public static int indexError;
        myGlobal() { }
        // indexError automatically initialized to 0
    void workOnArray(double[] myArray, int otherInfo) {
    int i = 0;
    // complicated calculation of array index i, using otherInfo
    if (i >= 0 && i < myArray.length) {
    myArray[i] = 3.14159;
    }
    else
    myGlobal.indexError = -1;
    }
}