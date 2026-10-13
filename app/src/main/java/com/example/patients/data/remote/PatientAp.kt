package com.example.patients.data.remote

import com.example.patients.data.model.Patient
import com.example.patients.data.model.PatientRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PatientApi {

    // Récupérer la liste des patients
    @GET("patients")
    suspend fun getPatients(
        @Query("statut") statut: String? = null
    ): List<Patient>

    // Récupérer un patient par son ID
    @GET("patients/{id}")
    suspend fun getPatient(
        @Path("id") id: String
    ): Patient

    // Ajouter un patient
    @POST("patients")
    suspend fun createPatient(
        @Body patient: PatientRequest
    ): Patient

    // Modifier un patient
    @PUT("patients/{id}")
    suspend fun updatePatient(
        @Path("id") id: String,
        @Body patient: PatientRequest
    ): Patient

    // Supprimer un patient
    @DELETE("patients/{id}")
    suspend fun deletePatient(
        @Path("id") id: String
    ): Response<Unit>
}
