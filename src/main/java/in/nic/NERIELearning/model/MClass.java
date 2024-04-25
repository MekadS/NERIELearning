package in.nic.NERIELearning.model;

import org.hibernate.annotations.GenericGenerator;

import in.nic.NERIELearning.config.ConstantUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table (name = "m_class")
public class MClass{
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "classId", nullable = false, unique = true, length = 5)
	private String classId;

	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_ONLY_NOT_NULL, message = "Invalid Class Name")
	@Column(name = "className", length = 20, nullable = false, unique = true)
	private String className;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "stageId")
	private MStage stageId;
}