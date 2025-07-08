    package com.example.CropEase.model;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;

    import java.util.List;

    @Entity
    public class RegisterSeller {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String business_name;
        private String owner_name;
        @Column(unique = true)
        private String email;
        private String phone_no;
        private String business_address;
        private String password;
        private String confirm_password;
        @ManyToOne
        @JoinColumn(name = "region_id")
        @JsonIgnoreProperties("sellers")
        private Region region;


        @OneToMany(mappedBy = "registerSeller", cascade = CascadeType.ALL)
        private List<Machine> machines;


        public RegisterSeller(){

        }
        public RegisterSeller(String business_name, String owner_name, String email, String phone_no, String business_address, String password, String confirm_password, Region region) {
            this.business_name = business_name;
            this.owner_name = owner_name;
            this.email = email;
            this.phone_no = phone_no;
            this.business_address = business_address;
            this.password = password;
            this.confirm_password = confirm_password;
            this.region = region;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }

        public Region getRegion() {
            return region;
        }

        public void setRegion(Region region) {
            this.region = region;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getBusiness_name() {
            return business_name;
        }

        public void setBusiness_name(String business_name) {
            this.business_name = business_name;
        }

        public String getOwner_name() {
            return owner_name;
        }

        public void setOwner_name(String owner_name) {
            this.owner_name = owner_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


        public String getBusiness_address() {
            return business_address;
        }

        public void setBusiness_address(String business_address) {
            this.business_address = business_address;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirm_password() {
            return confirm_password;
        }

        public void setConfirm_password(String confirm_password) {
            this.confirm_password = confirm_password;
        }



    }
