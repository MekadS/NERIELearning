package in.nic.NERIELearning.model;

import in.nic.NERIELearning.config.ConstantUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table (name = "m_stage")
public class MStage{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_stage_id_seq")
	@SequenceGenerator(name = "m_stage_id_seq", sequenceName = "M_STAGE_SEQ", allocationSize = 50, initialValue = 100)
	private Long mStageId;

	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_ONLY_NOT_NULL, message = "Invalid Stage Name")
	@Column(name = "mStageName", length = 50, nullable = false, unique = true)
	private String mStageName;

	@Builder.Default
	@Column(length = 1, nullable = false)
	private Boolean isActive = true;
}