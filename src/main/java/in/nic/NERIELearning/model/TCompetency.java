package in.nic.NERIELearning.model;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "t_competency")
public class TCompetency{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_competency_id_seq")
	@SequenceGenerator(name = "t_competency_id_seq", sequenceName = "T_COMPETENCY_SEQ", allocationSize = 5000, initialValue = 100)
	private Long tCompetencyId;
	
//	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_NUMBER_DASH_ONLY_NOT_NULL, message = "Invalid Class Name")
	@NotBlank
	@NotEmpty
	@Column(name = "tCompetencyName", length = 150, nullable = false, unique = true)
	private String tCompetencyName;

	@NotBlank
	@NotEmpty
	@Column(name = "tCompetencyDescription", length = 1000, nullable = false, unique = true)
	private String tCompetencyDescription;
	

	@Builder.Default
	@Column(length = 1, nullable = false)
	private Boolean isActive = true;
	
	@ManyToOne
	@JoinColumn(name = "mCompetencyId")
	private MCompetency mCompetencyId;

	@ManyToOne
	@JoinColumn(name = "tGoalId")
	private TGoal tGoalId;
}