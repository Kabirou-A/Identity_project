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
	

}
