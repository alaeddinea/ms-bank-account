package com.amama.msBankAccount.Audit;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
	@CreatedBy
	@Column(updatable = false)
	protected U createdBy;
	@CreatedDate
	@Column(updatable = false)
	protected Instant createdDate;
	@LastModifiedBy
	protected U lastModifiedBy;
	@LastModifiedDate
	protected Instant lastModifiedDate;
}
