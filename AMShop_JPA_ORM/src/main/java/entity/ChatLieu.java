package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
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
@Table(name = "ChatLieu")

public class ChatLieu implements Serializable {

	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "MaChatLieu")
	private String maChatLieu;
	
	@Column(name = "TenChatLieu")
	private String tenChatLieu;
	
}
