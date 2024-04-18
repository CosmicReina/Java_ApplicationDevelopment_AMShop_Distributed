package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "NhaSanXuat")
public class NhaSanXuat implements Serializable {
	
	private static final long serialVersionUID = -4836190162375273442L;
	
	private String maNhaSanXuat;
	private String tenNhaSanXuat;

}
