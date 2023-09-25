package com.cg.calc.pojos;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable

public class Variables {
	private int a;
	private String b ="hello";
}
