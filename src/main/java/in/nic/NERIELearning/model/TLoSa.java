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
@Table (name = "t_losa")
public class TLoSa{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_losa_id_seq")
	@SequenceGenerator(name = "t_losa_id_seq", sequenceName = "T_LOSA_SEQ", allocationSize = 5000, initialValue = 100)
	private Long tLoSaId;
	
	@NotBlank
	@NotEmpty
	@Column(name = "learningOutcome", length = 1000, nullable = false, unique = false)
	private String learningOutcome;

	@NotBlank
	@NotEmpty
	@Column(name = "suggestiveActivity", length = 1000, nullable = false, unique = false)
	private String suggestiveActivity;
	
	@Builder.Default
	@Column(length = 1, nullable = false)
	private Boolean isActive = true;
	
	@ManyToOne
	@JoinColumn(name = "tCompetencyId")
	private TCompetency tCompetencyId;
}