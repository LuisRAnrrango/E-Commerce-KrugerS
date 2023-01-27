package kruger.star.eccomerce.msvcestadopedidos.models.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private Long userId;
    private Long  payment_details_id;
    private BigDecimal total;
    private Date created_at;
    private Date modified_at;
    private Integer status;

    public OrderDetails(Long userId, Long payment_details_id, BigDecimal total, Date created_at, Date modified_at, Integer status) {
        this.userId = userId;
        this.payment_details_id = payment_details_id;
        this.total = total;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.status = status;
    }

    public OrderDetails() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPayment_details_id() {
        return payment_details_id;
    }

    public void setPayment_details_id(Long payment_details_id) {
        this.payment_details_id = payment_details_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
