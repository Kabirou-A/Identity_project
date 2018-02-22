package fr.epita.iam.datamodel;

public class Address {
	
	
	private String addressName;
	private String occupation;
	private String streetName;
	private String stateAreaDistrict;
	private String cityTownVillage;
	private String province;
	private String postalCode;
	private String country;
	
	/*
	 * @First construction to create an Address object and allow to set convenient attributes 
	 */
	public Address() {
		
	}
	/*
	 * @Second construction allow to create an address instance with one parameter and can be use to delete address by reference to that attribute
	 */
	public Address(String addressName) {
		
		this.addressName = addressName;
		
	}
	/*
	 * @Third construction to create an address instance with five common international standard of address
	 */
	public Address( String streetName, String cityTownVillage, String province, String postalCode, String country) {
		
		this.streetName = streetName;
		this.cityTownVillage = cityTownVillage;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	/*
	 * @Third construction to create an address instance for develop countries like UK, France or USA
	 */
	public Address(String addressName,String occupation, String streetName, String stateAreaDistrict, 
			String cityTownVillage, String province, String postalCode, String country) {
		this.addressName = addressName;
		this.occupation = occupation;
		this.streetName = streetName;
		this.stateAreaDistrict =  stateAreaDistrict;
		this.cityTownVillage = cityTownVillage;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	/**
	 * @return the addressName
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * @param addressName the addressName to set
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		occupation = occupation;
	}
	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		streetName = streetName;
	}
	/**
	 * @return the cityAreaDistrict
	 */
	public String getStateAreaDistrict() {
		return stateAreaDistrict;
	}
	/**
	 * @param cityAreaDistrict the cityAreaDistrict to set
	 */
	public void setStateAreaDistrict(String cityAreaDistrict) {
		stateAreaDistrict = cityAreaDistrict;
	}
	/**
	 * @return the cityTownVillage
	 */
	public String getCityTownVillage() {
		return cityTownVillage;
	}
	/**
	 * @param cityTownVillage the cityTownVillage to set
	 */
	public void setCityTownVillage(String cityTownVillage) {
		cityTownVillage = cityTownVillage;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		province = province;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		postalCode = postalCode;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		country = country;
	} 
	@Override
	public String toString() {
		return "Address [addressName= "+  addressName 
				+ ", streetName= " + streetName 
				+ ", stateAreaDistrict= " + stateAreaDistrict 
				+ ", cityTownVillage= " + cityTownVillage 
				+ ", province= " + province 
				+ ", postalCode= " + postalCode 
				+ ", country= " + country 
				+"]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressName == null) ? 0 : addressName.hashCode());
		result = prime * result + ((cityTownVillage == null) ? 0 : cityTownVillage.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((stateAreaDistrict == null) ? 0 : stateAreaDistrict.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressName == null) {
			if (other.addressName != null)
				return false;
		} else if (!addressName.equals(other.addressName))
			return false;
		if (cityTownVillage == null) {
			if (other.cityTownVillage != null)
				return false;
		} else if (!cityTownVillage.equals(other.cityTownVillage))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (stateAreaDistrict == null) {
			if (other.stateAreaDistrict != null)
				return false;
		} else if (!stateAreaDistrict.equals(other.stateAreaDistrict))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		return true;
	}
	

}
