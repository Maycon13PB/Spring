package br.com.maycon.rentacar.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDTO {

    private int id;

    private String modelName;

    private String assembler;

    private  int manufactureYear;

    private int modelYear;

    public String getFullName(){
        return this.modelName + "" + this.assembler;
    }
}
