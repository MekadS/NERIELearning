package in.nic.NERIELearning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_role")
public class MRole {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_role_id_seq")
	@SequenceGenerator(name = "m_role_id_seq", sequenceName = "M_ROLE_SEQ", allocationSize = 500, initialValue = 2000)
	private Long mRoleId;

	@NotBlank
	@NotEmpty
//	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_ONLY_WITH_SPACE_AND_UNDERSCORE, message = "Invalid Role Name")
	@Column(length = 30, nullable = false)
	private String roleName;

	@NotBlank
	@NotEmpty
	@Column(nullable = false)
	private String landingPage;

	@Builder.Default
	@Column(length = 1, nullable = false)
	private Boolean isActive = true;
}