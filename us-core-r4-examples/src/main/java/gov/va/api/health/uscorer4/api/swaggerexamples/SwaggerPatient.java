package gov.va.api.health.uscorer4.api.swaggerexamples;

import static java.util.Arrays.asList;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.Address;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.datatypes.HumanName;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.uscorer4.api.resources.Patient;
import java.util.Arrays;

public class SwaggerPatient {

  /**
   * An example Patient.
   *
   * @return an example Patient.
   */
  public static Patient patient() {
    return Patient.builder()
        .id("2000163")
        .resourceType("Patient")
        .extension(
            asList(
                Extension.builder()
                    .url("http://hl7.org/fhir/us/core/StructureDefinition/us-core-race")
                    .extension(
                        asList(
                            Extension.builder()
                                .url("ombCategory")
                                .valueCoding(
                                    Coding.builder()
                                        .system(
                                            "https://www.hl7.org/fhir/us/core/CodeSystem-cdcrec.html")
                                        .code("2016-3")
                                        .display("White")
                                        .build())
                                .build(),
                            Extension.builder().url("text").valueString("White").build()))
                    .build(),
                Extension.builder()
                    .url("http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity")
                    .extension(
                        asList(
                            Extension.builder()
                                .url("ombCategory")
                                .valueCoding(
                                    Coding.builder()
                                        .system(
                                            "https://www.hl7.org/fhir/us/core/CodeSystem-cdcrec.html")
                                        .code("2186-5")
                                        .display("Not Hispanic or Latino")
                                        .build())
                                .build(),
                            Extension.builder()
                                .url("text")
                                .valueString("Not Hispanic or Latino")
                                .build()))
                    .build(),
                Extension.builder()
                    .url("http://hl7.org/fhir/us/core/StructureDefinition/us-core-birthsex")
                    .valueCode("M")
                    .build()))
        .identifier(
            asList(
                Identifier.builder()
                    .use(Identifier.IdentifierUse.usual)
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                Arrays.asList(
                                    Coding.builder()
                                        .system("http://hl7.org/fhir/v2/0203")
                                        .code("MR")
                                        .build()))
                            .build())
                    .system("http://va.gov/mvi")
                    .value("2000163")
                    .build(),
                Identifier.builder()
                    .use(Identifier.IdentifierUse.official)
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                Arrays.asList(
                                    Coding.builder()
                                        .system("http://hl7.org/fhir/v2/0203")
                                        .code("SB")
                                        .build()))
                            .build())
                    .system("http://hl7.org/fhir/sid/us-ssn")
                    .value("999-61-4803")
                    .build()))
        .name(
            Arrays.asList(
                HumanName.builder()
                    .use(HumanName.NameUse.usual)
                    .text("Mr. Aurelio227 Cruickshank494")
                    .family("Cruickshank494")
                    .given(asList("Aurelio227"))
                    .build()))
        .telecom(
            asList(
                ContactPoint.builder()
                    .system(ContactPoint.ContactPointSystem.phone)
                    .value("5555191065")
                    .use(ContactPoint.ContactPointUse.mobile)
                    .build(),
                ContactPoint.builder()
                    .system(ContactPoint.ContactPointSystem.email)
                    .value("Aurelio227.Cruickshank494@email.example")
                    .build()))
        .gender(Patient.Gender.male)
        .birthDate("1995-02-06")
        .deceasedBoolean("false")
        .address(
            Arrays.asList(
                Address.builder()
                    .line(asList("909 Rohan Highlands"))
                    .city("Mesa")
                    .state("Arizona")
                    .postalCode("85120")
                    .build()))
        .maritalStatus(
            CodeableConcept.builder()
                .coding(
                    Arrays.asList(
                        Coding.builder()
                            .system("http://hl7.org/fhir/R4/v3/NullFlavor/cs.html")
                            .code("UNK")
                            .display("unknown")
                            .build()))
                .build())
        .build();
  }

  /**
   * An example Bundle.
   *
   * @return an example Bundle.
   */
  public static Patient.Bundle patientBundle() {
    return Patient.Bundle.builder()
        .resourceType("Bundle")
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            asList(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient?identifier=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient?identifier=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient?identifer=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(Arrays.asList(Patient.Entry.builder().resource(patient()).build()))
        .build();
  }
}
