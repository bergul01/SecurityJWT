package IslemBlok.IslemBlok.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "display_block")
@Entity
public class DisplayBlock extends BaseBlock{

	@Column(name = "display_value")
	private Double inputValue; //InputBlocktanda alınan değer
	
	@Override
	public Object execute() {
		
		System.out.println("Displaying: " + inputValue);
		return inputValue;
	}
	

}
