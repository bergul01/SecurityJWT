package IslemBlok.IslemBlok.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // her sınıf kendi tablosunda saklanır. Alt sınıflar üst sınıfın tablosuyla birleştirilir (join işlemi).
@Table(name = "base_blocks")
@Entity
public abstract class BaseBlock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "block_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	public abstract Object execute();
	
}
