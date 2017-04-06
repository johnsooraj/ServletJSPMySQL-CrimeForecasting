package com.crimeforcast.entitys;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Crimeforcastdataset.findAll", query = "SELECT c FROM Crimeforcastdataset c")
public class Crimeforcastdataset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int arson;

	@Column(name = "`ASSAULT ON WOMEN WITH INTENT TO OUTRAGE HER MODESTY`")
	private int assault_on_women_with_intent_to_outrage_her_modesty;

	@Column(name = "`ATTEMPT TO MURDER`")
	private int attempt_to_murder;

	private int burglary;

	@Column(name = "`CAUSING DEATH BY NEGLIGENCE`")
	private int causing_death_by_negligence;

	private int cheating;

	private int counterfieting;

	@Column(name = "`CRIMINAL BREACH OF TRUST`")
	private int criminal_breach_of_trust;

	@Column(name = "`CRUELTY BY HUSBAND OR HIS RELATIVES`")
	private int cruelty_by_husband_or_his_relatives;

	@Column(name = "`CULPABLE HOMICIDE NOT AMOUNTING TO MURDER`")
	private int culpable_homicide_not_amounting_to_murder;

	@Column(name = "`CUSTODIAL RAPE`")
	private int custodial_rape;

	private int dacoity;

	private String district;

	@Column(name = "`DOWRY DEATHS`")
	private int dowry_deaths;

	@Column(name = "`HURT/GREVIOUS HURT`")
	private int hurt_grevious_hurt;

	@Column(name = "`IMPORTATION OF GIRLS FROM FOREIGN COUNTRIES`")
	private int importation_of_girls_from_foreign_countries;

	@Column(name = "`INSULT TO MODESTY OF WOMEN`")
	private int insult_to_modesty_of_women;

	@Column(name = "`KIDNAPPING & ABDUCTION`")
	private int kidnapping___abduction;

	@Column(name = "`KIDNAPPING AND ABDUCTION OF OTHERS`")
	private int kidnapping_and_abduction_of_others;

	@Column(name = "`KIDNAPPING AND ABDUCTION OF WOMEN AND GIRLS`")
	private int kidnapping_and_abduction_of_women_and_girls;

	private int murder;

	@Column(name = "`OTHER IPC CRIMES`")
	private int other_ipc_crimes;

	@Column(name = "`OTHER RAPE`")
	private int other_rape;

	@Column(name = "`OTHER THEFT`")
	private int other_theft;

	@Column(name = "`PREPARATION AND ASSEMBLY FOR DACOITY`")
	private int preparation_and_assembly_for_dacoity;

	@Column(name = "`AUTO THEFT`")
	private int auto_theft;

	private int rape;

	private int riots;

	private int robbery;

	@Column(name = "`STATE/UT`")
	private String state_ut;

	private int theft;

	@Column(name = "`TOTAL IPC CRIMES`")
	private int total_ipc_crimes;

	private int year;

	public Crimeforcastdataset() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArson() {
		return this.arson;
	}

	public void setArson(int arson) {
		this.arson = arson;
	}

	public int getAssault_on_women_with_intent_to_outrage_her_modesty() {
		return this.assault_on_women_with_intent_to_outrage_her_modesty;
	}

	public void setAssault_on_women_with_intent_to_outrage_her_modesty(
			int assault_on_women_with_intent_to_outrage_her_modesty) {
		this.assault_on_women_with_intent_to_outrage_her_modesty = assault_on_women_with_intent_to_outrage_her_modesty;
	}

	public int getAttempt_to_murder() {
		return this.attempt_to_murder;
	}

	public void setAttempt_to_murder(int attempt_to_murder) {
		this.attempt_to_murder = attempt_to_murder;
	}

	public int getAuto_theft() {
		return this.auto_theft;
	}

	public void setAuto_theft(int auto_theft) {
		this.auto_theft = auto_theft;
	}

	public int getBurglary() {
		return this.burglary;
	}

	public void setBurglary(int burglary) {
		this.burglary = burglary;
	}

	public int getCausing_death_by_negligence() {
		return this.causing_death_by_negligence;
	}

	public void setCausing_death_by_negligence(int causing_death_by_negligence) {
		this.causing_death_by_negligence = causing_death_by_negligence;
	}

	public int getCheating() {
		return this.cheating;
	}

	public void setCheating(int cheating) {
		this.cheating = cheating;
	}

	public int getCounterfieting() {
		return this.counterfieting;
	}

	public void setCounterfieting(int counterfieting) {
		this.counterfieting = counterfieting;
	}

	public int getCriminal_breach_of_trust() {
		return this.criminal_breach_of_trust;
	}

	public void setCriminal_breach_of_trust(int criminal_breach_of_trust) {
		this.criminal_breach_of_trust = criminal_breach_of_trust;
	}

	public int getCruelty_by_husband_or_his_relatives() {
		return this.cruelty_by_husband_or_his_relatives;
	}

	public void setCruelty_by_husband_or_his_relatives(int cruelty_by_husband_or_his_relatives) {
		this.cruelty_by_husband_or_his_relatives = cruelty_by_husband_or_his_relatives;
	}

	public int getCulpable_homicide_not_amounting_to_murder() {
		return this.culpable_homicide_not_amounting_to_murder;
	}

	public void setCulpable_homicide_not_amounting_to_murder(int culpable_homicide_not_amounting_to_murder) {
		this.culpable_homicide_not_amounting_to_murder = culpable_homicide_not_amounting_to_murder;
	}

	public int getCustodial_rape() {
		return this.custodial_rape;
	}

	public void setCustodial_rape(int custodial_rape) {
		this.custodial_rape = custodial_rape;
	}

	public int getDacoity() {
		return this.dacoity;
	}

	public void setDacoity(int dacoity) {
		this.dacoity = dacoity;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getDowry_deaths() {
		return this.dowry_deaths;
	}

	public void setDowry_deaths(int dowry_deaths) {
		this.dowry_deaths = dowry_deaths;
	}

	public int getHurt_grevious_hurt() {
		return this.hurt_grevious_hurt;
	}

	public void setHurt_grevious_hurt(int hurt_grevious_hurt) {
		this.hurt_grevious_hurt = hurt_grevious_hurt;
	}

	public int getImportation_of_girls_from_foreign_countries() {
		return this.importation_of_girls_from_foreign_countries;
	}

	public void setImportation_of_girls_from_foreign_countries(int importation_of_girls_from_foreign_countries) {
		this.importation_of_girls_from_foreign_countries = importation_of_girls_from_foreign_countries;
	}

	public int getInsult_to_modesty_of_women() {
		return this.insult_to_modesty_of_women;
	}

	public void setInsult_to_modesty_of_women(int insult_to_modesty_of_women) {
		this.insult_to_modesty_of_women = insult_to_modesty_of_women;
	}

	public int getKidnapping___abduction() {
		return this.kidnapping___abduction;
	}

	public void setKidnapping___abduction(int kidnapping___abduction) {
		this.kidnapping___abduction = kidnapping___abduction;
	}

	public int getKidnapping_and_abduction_of_others() {
		return this.kidnapping_and_abduction_of_others;
	}

	public void setKidnapping_and_abduction_of_others(int kidnapping_and_abduction_of_others) {
		this.kidnapping_and_abduction_of_others = kidnapping_and_abduction_of_others;
	}

	public int getKidnapping_and_abduction_of_women_and_girls() {
		return this.kidnapping_and_abduction_of_women_and_girls;
	}

	public void setKidnapping_and_abduction_of_women_and_girls(int kidnapping_and_abduction_of_women_and_girls) {
		this.kidnapping_and_abduction_of_women_and_girls = kidnapping_and_abduction_of_women_and_girls;
	}

	public int getMurder() {
		return this.murder;
	}

	public void setMurder(int murder) {
		this.murder = murder;
	}

	public int getOther_ipc_crimes() {
		return this.other_ipc_crimes;
	}

	public void setOther_ipc_crimes(int other_ipc_crimes) {
		this.other_ipc_crimes = other_ipc_crimes;
	}

	public int getOther_rape() {
		return this.other_rape;
	}

	public void setOther_rape(int other_rape) {
		this.other_rape = other_rape;
	}

	public int getOther_theft() {
		return this.other_theft;
	}

	public void setOther_theft(int other_theft) {
		this.other_theft = other_theft;
	}

	public int getPreparation_and_assembly_for_dacoity() {
		return this.preparation_and_assembly_for_dacoity;
	}

	public void setPreparation_and_assembly_for_dacoity(int preparation_and_assembly_for_dacoity) {
		this.preparation_and_assembly_for_dacoity = preparation_and_assembly_for_dacoity;
	}

	public int getRape() {
		return this.rape;
	}

	public void setRape(int rape) {
		this.rape = rape;
	}

	public int getRiots() {
		return this.riots;
	}

	public void setRiots(int riots) {
		this.riots = riots;
	}

	public int getRobbery() {
		return this.robbery;
	}

	public void setRobbery(int robbery) {
		this.robbery = robbery;
	}

	public String getState_ut() {
		return this.state_ut;
	}

	public void setState_ut(String state_ut) {
		this.state_ut = state_ut;
	}

	public int getTheft() {
		return this.theft;
	}

	public void setTheft(int theft) {
		this.theft = theft;
	}

	public int getTotal_ipc_crimes() {
		return this.total_ipc_crimes;
	}

	public void setTotal_ipc_crimes(int total_ipc_crimes) {
		this.total_ipc_crimes = total_ipc_crimes;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}