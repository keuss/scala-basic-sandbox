package com.cgi

/**
 * @author galloisg
 */
case class Projet (
  idProjet: String,
  montant: Double,
  client: Option[Societe]
)