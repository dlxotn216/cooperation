package taesu.faster.coop.cooperation.code.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Lee Tae Su 
 * @project cooperation
 * @version 1.0
 * @since 2018-02-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CODE")
public class Code implements Serializable {
	
	@Id
	@Column(name = "CODE_KEY")
	private Long codeKey;
	
	@Column(name="CODE_SEQ")
	private Integer codeSeq;
	
	@Column(name="CODE_TYPE")
	private Integer codeType;
	
	@Column(name ="CODE_NAME")
	private String codeName;
}
