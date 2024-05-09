package in.nic.NERIELearning.model;

import in.nic.NERIELearning.config.ConstantUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_role")
public class MRole {
	@Id
	@Column(length = 20, nullable = false)
	private String roleCode;

	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_ALPHABET_ONLY_WITH_SPACE_AND_UNDERSCORE, message = "Invalid Role Name")
	@Column(length = 30, nullable = false)
	private String roleName;

	@NotBlank
	@NotEmpty
	@Column(nullable = false)
	private String landingPage;
}