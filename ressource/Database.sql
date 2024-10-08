PGDMP                      |        	   Jiblio_v2    16.2    16.0 '    &           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            '           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            (           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            )           1262    24593 	   Jiblio_v2    DATABASE     �   CREATE DATABASE "Jiblio_v2" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "Jiblio_v2";
                postgres    false            P           1247    24616    role    TYPE     F   CREATE TYPE public.role AS ENUM (
    'etudiant',
    'professeur'
);
    DROP TYPE public.role;
       public          postgres    false            �            1259    24770 	   borrowing    TABLE     #  CREATE TABLE public.borrowing (
    id uuid NOT NULL,
    utilisateur_id uuid,
    document_id uuid,
    isborrowing boolean DEFAULT false,
    isreserving boolean DEFAULT false,
    borrowed_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    returndate character varying(250)
);
    DROP TABLE public.borrowing;
       public         heap    postgres    false            �            1259    24663 	   documents    TABLE     I  CREATE TABLE public.documents (
    id uuid NOT NULL,
    titre character varying(50) NOT NULL,
    auteur character varying(50) NOT NULL,
    datepublication character varying(100) NOT NULL,
    nombredepages integer,
    isborrowed boolean DEFAULT false,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.documents;
       public         heap    postgres    false            �            1259    24717    utilisateurs    TABLE       CREATE TABLE public.utilisateurs (
    id uuid NOT NULL,
    username character varying(250) NOT NULL,
    email character varying(250) NOT NULL,
    password character varying(250) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
     DROP TABLE public.utilisateurs;
       public         heap    postgres    false            �            1259    24727 	   etudiants    TABLE     l   CREATE TABLE public.etudiants (
    filiere_etudes character varying(200)
)
INHERITS (public.utilisateurs);
    DROP TABLE public.etudiants;
       public         heap    postgres    false    220            �            1259    24680    journalscientifiques    TABLE        CREATE TABLE public.journalscientifiques (
    domainerecherche character varying(200) NOT NULL
)
INHERITS (public.documents);
 (   DROP TABLE public.journalscientifiques;
       public         heap    postgres    false    215            �            1259    24670    livres    TABLE     M   CREATE TABLE public.livres (
    isbn integer
)
INHERITS (public.documents);
    DROP TABLE public.livres;
       public         heap    postgres    false    215            �            1259    24675 	   magazines    TABLE     R   CREATE TABLE public.magazines (
    numero integer
)
INHERITS (public.documents);
    DROP TABLE public.magazines;
       public         heap    postgres    false    215            �            1259    24733    professeurs    TABLE     o   CREATE TABLE public.professeurs (
    modele_enseigne character varying(200)
)
INHERITS (public.utilisateurs);
    DROP TABLE public.professeurs;
       public         heap    postgres    false    220            �            1259    24685    thesesuniversitaire    TABLE     �   CREATE TABLE public.thesesuniversitaire (
    universite character varying(100) NOT NULL,
    domaine character varying(100) NOT NULL
)
INHERITS (public.documents);
 '   DROP TABLE public.thesesuniversitaire;
       public         heap    postgres    false    215            }           2604    24730    etudiants created_at    DEFAULT     Y   ALTER TABLE ONLY public.etudiants ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
 C   ALTER TABLE public.etudiants ALTER COLUMN created_at DROP DEFAULT;
       public          postgres    false    221            x           2604    24683    journalscientifiques isborrowed    DEFAULT     X   ALTER TABLE ONLY public.journalscientifiques ALTER COLUMN isborrowed SET DEFAULT false;
 N   ALTER TABLE public.journalscientifiques ALTER COLUMN isborrowed DROP DEFAULT;
       public          postgres    false    218            y           2604    24684    journalscientifiques created_at    DEFAULT     d   ALTER TABLE ONLY public.journalscientifiques ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
 N   ALTER TABLE public.journalscientifiques ALTER COLUMN created_at DROP DEFAULT;
       public          postgres    false    218            t           2604    24673    livres isborrowed    DEFAULT     J   ALTER TABLE ONLY public.livres ALTER COLUMN isborrowed SET DEFAULT false;
 @   ALTER TABLE public.livres ALTER COLUMN isborrowed DROP DEFAULT;
       public          postgres    false    216            u           2604    24674    livres created_at    DEFAULT     V   ALTER TABLE ONLY public.livres ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
 @   ALTER TABLE public.livres ALTER COLUMN created_at DROP DEFAULT;
       public          postgres    false    216            v           2604    24678    magazines isborrowed    DEFAULT     M   ALTER TABLE ONLY public.magazines ALTER COLUMN isborrowed SET DEFAULT false;
 C   ALTER TABLE public.magazines ALTER COLUMN isborrowed DROP DEFAULT;
       public          postgres    false    217            w           2604    24679    magazines created_at    DEFAULT     Y   ALTER TABLE ONLY public.magazines ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
 C   ALTER TABLE public.magazines ALTER COLUMN created_at DROP DEFAULT;
       public          postgres    false    217            ~           2604    24736    professeurs created_at    DEFAULT     [   ALTER TABLE ONLY public.professeurs ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
 E   ALTER TABLE public.professeurs ALTER COLUMN created_at DROP DEFAULT;
       public          postgres    false    222            z           2604    24688    thesesuniversitaire isborrowed    DEFAULT     W   ALTER TABLE ONLY public.thesesuniversitaire ALTER COLUMN isborrowed SET DEFAULT false;
 M   ALTER TABLE public.thesesuniversitaire ALTER COLUMN isborrowed DROP DEFAULT;
       public          postgres    false    219            {           2604    24689    thesesuniversitaire created_at    DEFAULT     c   ALTER TABLE ONLY public.thesesuniversitaire ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
 M   ALTER TABLE public.thesesuniversitaire ALTER COLUMN created_at DROP DEFAULT;
       public          postgres    false    219            #          0    24770 	   borrowing 
   TABLE DATA           w   COPY public.borrowing (id, utilisateur_id, document_id, isborrowing, isreserving, borrowed_at, returndate) FROM stdin;
    public          postgres    false    223   �-                 0    24663 	   documents 
   TABLE DATA           n   COPY public.documents (id, titre, auteur, datepublication, nombredepages, isborrowed, created_at) FROM stdin;
    public          postgres    false    215   y.       !          0    24727 	   etudiants 
   TABLE DATA           ^   COPY public.etudiants (id, username, email, password, created_at, filiere_etudes) FROM stdin;
    public          postgres    false    221   n/                 0    24680    journalscientifiques 
   TABLE DATA           �   COPY public.journalscientifiques (id, titre, auteur, datepublication, nombredepages, isborrowed, created_at, domainerecherche) FROM stdin;
    public          postgres    false    218   �/                 0    24670    livres 
   TABLE DATA           q   COPY public.livres (id, titre, auteur, datepublication, nombredepages, isborrowed, created_at, isbn) FROM stdin;
    public          postgres    false    216   :0                 0    24675 	   magazines 
   TABLE DATA           v   COPY public.magazines (id, titre, auteur, datepublication, nombredepages, isborrowed, created_at, numero) FROM stdin;
    public          postgres    false    217   �0       "          0    24733    professeurs 
   TABLE DATA           a   COPY public.professeurs (id, username, email, password, created_at, modele_enseigne) FROM stdin;
    public          postgres    false    222   1                 0    24685    thesesuniversitaire 
   TABLE DATA           �   COPY public.thesesuniversitaire (id, titre, auteur, datepublication, nombredepages, isborrowed, created_at, universite, domaine) FROM stdin;
    public          postgres    false    219   s1                  0    24717    utilisateurs 
   TABLE DATA           Q   COPY public.utilisateurs (id, username, email, password, created_at) FROM stdin;
    public          postgres    false    220   �1       �           2606    24777    borrowing borrowing_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.borrowing
    ADD CONSTRAINT borrowing_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.borrowing DROP CONSTRAINT borrowing_pkey;
       public            postgres    false    223            �           2606    24669    documents documents_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.documents
    ADD CONSTRAINT documents_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.documents DROP CONSTRAINT documents_pkey;
       public            postgres    false    215            �           2606    24726 #   utilisateurs utilisateurs_email_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.utilisateurs
    ADD CONSTRAINT utilisateurs_email_key UNIQUE (email);
 M   ALTER TABLE ONLY public.utilisateurs DROP CONSTRAINT utilisateurs_email_key;
       public            postgres    false    220            �           2606    24724    utilisateurs utilisateurs_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.utilisateurs
    ADD CONSTRAINT utilisateurs_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.utilisateurs DROP CONSTRAINT utilisateurs_pkey;
       public            postgres    false    220            �           2606    24783 $   borrowing borrowing_document_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.borrowing
    ADD CONSTRAINT borrowing_document_id_fkey FOREIGN KEY (document_id) REFERENCES public.documents(id);
 N   ALTER TABLE ONLY public.borrowing DROP CONSTRAINT borrowing_document_id_fkey;
       public          postgres    false    215    4739    223            �           2606    24778 '   borrowing borrowing_utilisateur_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.borrowing
    ADD CONSTRAINT borrowing_utilisateur_id_fkey FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateurs(id);
 Q   ALTER TABLE ONLY public.borrowing DROP CONSTRAINT borrowing_utilisateur_id_fkey;
       public          postgres    false    4743    220    223            #   z   x�ʹ�0 �Z�"��ǳ��(r��$���B{O� d0�]*���X�X���i�@%������R��xd��0� lq��mk��,���H^�7��j$�I!~��C}�Z�{A%�         �   x�]�9n�@DѸ��@S�g9����M���؀�*z�����մ��11� l���%6�s'��c ��.D&j�@H� 덹R���]sS4����Ɩ0����<��"�p�u�.���OY�څ��;�^���b��ݮlu�NSO���n�ñ`��\�Wl7��T���QR��h�w�f�Fֱxc�e��ح{��9�	�:�����@E>y�մj�b�D%<��7K�U~      !   U   x���� @ѳL�0b����"�R��w�b��J�΂Y�`�9����ٳJp�|��'Θ�\D�Ir$"�l��� �M!�         W   x����  �7L�����Y�A�Ҥ��>��(�Ǎ�d'_<���s_���8D�(h6PV#�$v1�%�R�}߄��h�         [   x�ɱ� �:L��$?(0�\@�z�	���1�sL.�F�g�/�w>/��O�bS�LD���9KeŢڤ6�ZѲ,�kJ��         X   x���� D��R�,���x���&?/�6d��ru�Sf���q�Y�M�3׏�/z�)]Q��Fkn��F�0y�b�v      "   V   x��;�  й����'P���q��I��\�0��MX����`}��E\����x��>�C�	BbH�l��|�$�;�*3ҙSJ?H         m   x��K�0 ���^`p~%���)eY���$�^H��-�FK<���hdS��ZI5+9B{��{��e`����@E��U��l7~L���!�H��7?ֽ�`���yx!�?�o�          |   x�U�1� �N�8����%M������Ҳ�J3�S?��S';Z&��t��Pv�j��84���~KP2bݘϕb�Z%���*�K3!c�TZr܉s��>������ڙ!�x�1�/Y{'�     