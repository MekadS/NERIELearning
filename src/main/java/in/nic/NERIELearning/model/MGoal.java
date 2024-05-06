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
@Table (name = "m_goal")
public class MGoal{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_goal_id_seq")
	@SequenceGenerator(name = "m_goal_id_seq", sequenceName = "M_GOAL_SEQ", allocationSize = 200, initialValue = 100)
	private Long mGoalId;
	
	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_NUMBER_DASH_ONLY_NOT_NULL, message = "Invalid Goal Name")
	@Column(name = "mGoalName", length = 10, nullable = false, unique = true)
	private String mGoalCode;
}

