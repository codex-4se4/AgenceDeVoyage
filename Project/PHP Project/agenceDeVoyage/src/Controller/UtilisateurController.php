<?php

namespace App\Controller;

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
        $form = $this->createForm(UtilisateurFormType::class);

        return $this->render("utilisateur/utilisateur-form.html.twig",[
            "form_title" => "Ajouter utilisateur",
            "form_utilisateur" => $form->createView(),
        ]);
    }
}
