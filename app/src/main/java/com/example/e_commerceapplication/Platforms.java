package com.example.e_commerceapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platforms {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("NumberOfSales")
        @Expose
        private int numberOfSales;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumberOfSales() {
            return numberOfSales;
        }

        public void setNumberOfSales(int numberOfSales) {
            this.numberOfSales = numberOfSales;
        }
}

