package in.nic.NERIELearning.model;

import in.nic.NERIELearning.config.ConstantUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "m_class")
public class MClass{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_class_id_seq")
	@SequenceGenerator(name = "m_class_id_seq", sequenceName = "M_CLASS_SEQ", allocationSize = 50, initialValue = 100)
	private Long mClassId;

	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET__NUMBER_ONLY_NOT_NULL, message = "Invalid Class Name")
	@Column(name = "mStageName", length = 50, nullable = false, unique = true)
	private String mClassName;

	@Builder.Default
	@Column(length = 1, nullable = false)
	private Boolean isActive = true;
	
	@ManyToOne
	@JoinColumn(name = "mStageId")
	private MStage mStageId;
}