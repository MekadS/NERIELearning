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
@Table (name = "t_goal")
public class TGoal{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_goal_id_seq")
	@SequenceGenerator(name = "t_goal_id_seq", sequenceName = "T_GOAL_SEQ", allocationSize = 200, initialValue = 100)
	private Long tGoalId;
	
//	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_NUMBER_DASH_ONLY_NOT_NULL, message = "Invalid Class Name")
	@NotBlank
	@NotEmpty
	@Column(name = "tGoalName", length = 150, nullable = false, unique = true)
	private String tGoalName;

	@NotBlank
	@NotEmpty
	@Column(name = "tGoalDescription", length = 1000, nullable = false, unique = true)
	private String tGoalDescription;
	
	@ManyToOne
	@JoinColumn(name = "mGoalId")
	private MGoal mGoalId;

	@ManyToOne
	@JoinColumn(name = "mapClassSubjectId")
	private MapClassSubject mapClassSubjectId;
}