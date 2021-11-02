<?php

namespace App\Controller;

use App\Entity\Utilisateur;
use App\Form\UtilisateurFormType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class UtilisateurController extends AbstractController
{
    /**
     * @Route("/utilisateur", name="utilisateur")
     */
    public function index(): Response
    {
        return $this->render('utilisateur/index.html.twig', [
            'controller_name' => 'UtilisateurController',
        ]);
    }

    /**
     * @Route("/ajouter-utilisateur", name="ajouter_utilisateur")
     */
    public function ajouterUtilisateur(Request $request): Response
    {
        $utilisateur = new Utilisateur();
        $form = $this->createForm(UtilisateurFormType::class,$utilisateur);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($utilisateur);
            $entityManager->flush();
        }

        return $this->render("utilisateur/utilisateur-form.html.twig",[
            "form_title" => "Ajouter utilisateur",
            "form_utilisateur" => $form->createView(),
        ]);
    }

    /**
     * @Route("/utilisateurs", name="utilisateurs")
     */
    public function utilisateurs()
    {
        $utilisateurs = $this->getDoctrine()->getRepository(Utilisateur::class)->findAll();

        return $this->render('utilisateur/utilisateurs.html.twig', [
            "utilisateurs" => $utilisateurs,
        ]);
    }

    /**
     * @Route("/utilisateur/{id}", name="utilisateur")
     */
    public function utilisateur(int $id): Response
    {
        $utilisateur = $this->getDoctrine()->getRepository(Utilisateur::class)->find($id);

        return $this->render("utilisateur/utilisateur.html.twig", [
            "utilisateur" => $$utilisateur,
        ]);
    }
}
