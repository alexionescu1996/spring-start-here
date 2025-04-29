package org.example.data;

import lombok.Data;

@Data
public class Parrot {
    private String name;

    public Parrot() {
        System.out.println("Created a new Parrot");
    }
}
