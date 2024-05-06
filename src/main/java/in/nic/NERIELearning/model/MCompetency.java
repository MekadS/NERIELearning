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
@Table (name = "m_competency")
public class MCompetency{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_competency_id_seq")
	@SequenceGenerator(name = "m_competency_id_seq", sequenceName = "M_COMPETENCY_SEQ", allocationSize = 200, initialValue = 100)
	private Long mCompetencyId;
	
	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_NUMBER_DASH_ONLY_NOT_NULL, message = "Invalid COmpetency Name")
	@Column(name = "mCompetencyName", length = 10, nullable = false, unique = true)
	private String mCompetencyCode;
}
