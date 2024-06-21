package in.nic.NERIELearning.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "m_content")
public class MContent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_content_id_seq")
	@SequenceGenerator(name = "m_content_id_seq", sequenceName = "M_CONTENT_SEQ", allocationSize = 50000, initialValue = 100)
	private Long mContentId;

	@NotBlank(message = "Content name cannot be blank")
	@NotEmpty(message = "Content type cannot be blank")
	private String mContentName;

	private byte[] mContentFile;

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Builder.Default
	@Column(length = 1, nullable = false)
	private Boolean isActive = true;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mapClassSubjectId")
	private MapClassSubject mapClassSubjectId;
}