package in.nic.NERIELearning.model;

import org.hibernate.annotations.GenericGenerator;

import in.nic.NERIELearning.config.ConstantUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table (name = "m_stage")
public class MStage{
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "stageId", nullable = false, unique = true, length = 5)
	private String stageId;
	
	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_ONLY_NOT_NULL, message = "Invalid Stage Name")
	@Column(name = "stageName", length = 50, nullable = false, unique = true)
	private String stageName;
}