PGDMP     2                    |            NERIELearningAppDB    13.12    13.12 M    /           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            0           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            1           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            2           1262    16608    NERIELearningAppDB    DATABASE     p   CREATE DATABASE "NERIELearningAppDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
 $   DROP DATABASE "NERIELearningAppDB";
                testuser    false                        2615    17055    nerielearning    SCHEMA        CREATE SCHEMA nerielearning;
    DROP SCHEMA nerielearning;
                testuser    false            �            1259    17151    m_class    TABLE     �   CREATE TABLE nerielearning.m_class (
    class_code bigint NOT NULL,
    class_name character varying(255),
    stage_code_stage_code bigint
);
 "   DROP TABLE nerielearning.m_class;
       nerielearning         heap    testuser    false    5            �            1259    17284    m_competency    TABLE     �   CREATE TABLE nerielearning.m_competency (
    competency_id character varying(255) NOT NULL,
    competency_code character varying(10)
);
 '   DROP TABLE nerielearning.m_competency;
       nerielearning         heap    testuser    false    5            �            1259    17177    m_goal    TABLE     x   CREATE TABLE nerielearning.m_goal (
    goal_id character varying(255) NOT NULL,
    goal_code character varying(10)
);
 !   DROP TABLE nerielearning.m_goal;
       nerielearning         heap    testuser    false    5            �            1259    17182    m_stage    TABLE     n   CREATE TABLE nerielearning.m_stage (
    stage_code bigint NOT NULL,
    stage_name character varying(255)
);
 "   DROP TABLE nerielearning.m_stage;
       nerielearning         heap    testuser    false    5            �            1259    17187 	   m_subject    TABLE     �   CREATE TABLE nerielearning.m_subject (
    subject_code bigint NOT NULL,
    subject_name character varying(255),
    class_code_class_code bigint
);
 $   DROP TABLE nerielearning.m_subject;
       nerielearning         heap    testuser    false    5            �            1259    17251    t_competency    TABLE     '  CREATE TABLE nerielearning.t_competency (
    t_competency_id character varying(255) NOT NULL,
    competency_description character varying(1000) NOT NULL,
    competency_name character varying(150) NOT NULL,
    competency_id character varying(255),
    curriculum_id character varying(255)
);
 '   DROP TABLE nerielearning.t_competency;
       nerielearning         heap    testuser    false    5            �            1259    17294    t_curriculum_goal    TABLE       CREATE TABLE nerielearning.t_curriculum_goal (
    curriculum_id character varying(255) NOT NULL,
    curriculum_description character varying(1000),
    curriculum_name character varying(150),
    class_code bigint,
    goal_id character varying(255),
    subject_code bigint
);
 ,   DROP TABLE nerielearning.t_curriculum_goal;
       nerielearning         heap    testuser    false    5            �            1259    17449    t_lo_sa    TABLE     �   CREATE TABLE nerielearning.t_lo_sa (
    lo_sa_code character varying(255) NOT NULL,
    learning_outcome character varying(1000),
    suggestive_activity character varying(1000),
    t_competency_id character varying(255)
);
 "   DROP TABLE nerielearning.t_lo_sa;
       nerielearning         heap    testuser    false    5            �            1259    16610    m_class    TABLE     �   CREATE TABLE public.m_class (
    class_code bigint NOT NULL,
    class_name character varying(255),
    stage_code_stage_code bigint
);
    DROP TABLE public.m_class;
       public         heap    testuser    false            �            1259    16640    m_class_seq    SEQUENCE     u   CREATE SEQUENCE public.m_class_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.m_class_seq;
       public          testuser    false            �            1259    16677    m_class_subject    TABLE     r   CREATE TABLE public.m_class_subject (
    csid bigint NOT NULL,
    class_code bigint,
    subject_code bigint
);
 #   DROP TABLE public.m_class_subject;
       public         heap    testuser    false            �            1259    16682    m_class_subject_seq    SEQUENCE     }   CREATE SEQUENCE public.m_class_subject_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.m_class_subject_seq;
       public          testuser    false            �            1259    16839    m_competencies    TABLE     �   CREATE TABLE public.m_competencies (
    competencies_code bigint NOT NULL,
    competencies_name character varying(255) NOT NULL,
    curriculum_code bigint
);
 "   DROP TABLE public.m_competencies;
       public         heap    testuser    false            �            1259    16642    m_competencies_seq    SEQUENCE     |   CREATE SEQUENCE public.m_competencies_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.m_competencies_seq;
       public          testuser    false            �            1259    16709    m_curriculum_goal    TABLE     {   CREATE TABLE public.m_curriculum_goal (
    curriculum_code bigint NOT NULL,
    curriculum_name character varying(255)
);
 %   DROP TABLE public.m_curriculum_goal;
       public         heap    testuser    false            �            1259    16644    m_curriculum_goal_seq    SEQUENCE        CREATE SEQUENCE public.m_curriculum_goal_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.m_curriculum_goal_seq;
       public          testuser    false            �            1259    16714    m_learning_outcome    TABLE     �   CREATE TABLE public.m_learning_outcome (
    loutcome_code bigint NOT NULL,
    loutcome_name character varying(255),
    competencies_code_competencies_code bigint
);
 &   DROP TABLE public.m_learning_outcome;
       public         heap    testuser    false            �            1259    16646    m_learning_outcome_seq    SEQUENCE     �   CREATE SEQUENCE public.m_learning_outcome_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.m_learning_outcome_seq;
       public          testuser    false            �            1259    16630    m_stage    TABLE     g   CREATE TABLE public.m_stage (
    stage_code bigint NOT NULL,
    stage_name character varying(255)
);
    DROP TABLE public.m_stage;
       public         heap    testuser    false            �            1259    16648    m_stage_seq    SEQUENCE     u   CREATE SEQUENCE public.m_stage_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.m_stage_seq;
       public          testuser    false            �            1259    16694 	   m_subject    TABLE     m   CREATE TABLE public.m_subject (
    subject_code bigint NOT NULL,
    subject_name character varying(255)
);
    DROP TABLE public.m_subject;
       public         heap    testuser    false            �            1259    16650    m_subject_seq    SEQUENCE     w   CREATE SEQUENCE public.m_subject_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.m_subject_seq;
       public          testuser    false            %          0    17151    m_class 
   TABLE DATA           W   COPY nerielearning.m_class (class_code, class_name, stage_code_stage_code) FROM stdin;
    nerielearning          testuser    false    215   �^       *          0    17284    m_competency 
   TABLE DATA           M   COPY nerielearning.m_competency (competency_id, competency_code) FROM stdin;
    nerielearning          testuser    false    220   6_       &          0    17177    m_goal 
   TABLE DATA           ;   COPY nerielearning.m_goal (goal_id, goal_code) FROM stdin;
    nerielearning          testuser    false    216   �`       '          0    17182    m_stage 
   TABLE DATA           @   COPY nerielearning.m_stage (stage_code, stage_name) FROM stdin;
    nerielearning          testuser    false    217   �`       (          0    17187 	   m_subject 
   TABLE DATA           ]   COPY nerielearning.m_subject (subject_code, subject_name, class_code_class_code) FROM stdin;
    nerielearning          testuser    false    218   Oa       )          0    17251    t_competency 
   TABLE DATA           �   COPY nerielearning.t_competency (t_competency_id, competency_description, competency_name, competency_id, curriculum_id) FROM stdin;
    nerielearning          testuser    false    219   �a       +          0    17294    t_curriculum_goal 
   TABLE DATA           �   COPY nerielearning.t_curriculum_goal (curriculum_id, curriculum_description, curriculum_name, class_code, goal_id, subject_code) FROM stdin;
    nerielearning          testuser    false    221   �f       ,          0    17449    t_lo_sa 
   TABLE DATA           l   COPY nerielearning.t_lo_sa (lo_sa_code, learning_outcome, suggestive_activity, t_competency_id) FROM stdin;
    nerielearning          testuser    false    222   �h                 0    16610    m_class 
   TABLE DATA           P   COPY public.m_class (class_code, class_name, stage_code_stage_code) FROM stdin;
    public          testuser    false    201   �o                 0    16677    m_class_subject 
   TABLE DATA           I   COPY public.m_class_subject (csid, class_code, subject_code) FROM stdin;
    public          testuser    false    209   7p       $          0    16839    m_competencies 
   TABLE DATA           _   COPY public.m_competencies (competencies_code, competencies_name, curriculum_code) FROM stdin;
    public          testuser    false    214   yp       "          0    16709    m_curriculum_goal 
   TABLE DATA           M   COPY public.m_curriculum_goal (curriculum_code, curriculum_name) FROM stdin;
    public          testuser    false    212   �t       #          0    16714    m_learning_outcome 
   TABLE DATA           o   COPY public.m_learning_outcome (loutcome_code, loutcome_name, competencies_code_competencies_code) FROM stdin;
    public          testuser    false    213   w                 0    16630    m_stage 
   TABLE DATA           9   COPY public.m_stage (stage_code, stage_name) FROM stdin;
    public          testuser    false    202   Zz       !          0    16694 	   m_subject 
   TABLE DATA           ?   COPY public.m_subject (subject_code, subject_name) FROM stdin;
    public          testuser    false    211   �z       3           0    0    m_class_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.m_class_seq', 1, false);
          public          testuser    false    203            4           0    0    m_class_subject_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.m_class_subject_seq', 1, false);
          public          testuser    false    210            5           0    0    m_competencies_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.m_competencies_seq', 1, false);
          public          testuser    false    204            6           0    0    m_curriculum_goal_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.m_curriculum_goal_seq', 1, false);
          public          testuser    false    205            7           0    0    m_learning_outcome_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.m_learning_outcome_seq', 1, false);
          public          testuser    false    206            8           0    0    m_stage_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.m_stage_seq', 1, false);
          public          testuser    false    207            9           0    0    m_subject_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.m_subject_seq', 1, false);
          public          testuser    false    208            y           2606    17155    m_class m_class_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY nerielearning.m_class
    ADD CONSTRAINT m_class_pkey PRIMARY KEY (class_code);
 E   ALTER TABLE ONLY nerielearning.m_class DROP CONSTRAINT m_class_pkey;
       nerielearning            testuser    false    215            �           2606    17288    m_competency m_competency_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY nerielearning.m_competency
    ADD CONSTRAINT m_competency_pkey PRIMARY KEY (competency_id);
 O   ALTER TABLE ONLY nerielearning.m_competency DROP CONSTRAINT m_competency_pkey;
       nerielearning            testuser    false    220            {           2606    17181    m_goal m_goal_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY nerielearning.m_goal
    ADD CONSTRAINT m_goal_pkey PRIMARY KEY (goal_id);
 C   ALTER TABLE ONLY nerielearning.m_goal DROP CONSTRAINT m_goal_pkey;
       nerielearning            testuser    false    216            }           2606    17186    m_stage m_stage_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY nerielearning.m_stage
    ADD CONSTRAINT m_stage_pkey PRIMARY KEY (stage_code);
 E   ALTER TABLE ONLY nerielearning.m_stage DROP CONSTRAINT m_stage_pkey;
       nerielearning            testuser    false    217                       2606    17191    m_subject m_subject_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY nerielearning.m_subject
    ADD CONSTRAINT m_subject_pkey PRIMARY KEY (subject_code);
 I   ALTER TABLE ONLY nerielearning.m_subject DROP CONSTRAINT m_subject_pkey;
       nerielearning            testuser    false    218            �           2606    17258    t_competency t_competency_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY nerielearning.t_competency
    ADD CONSTRAINT t_competency_pkey PRIMARY KEY (t_competency_id);
 O   ALTER TABLE ONLY nerielearning.t_competency DROP CONSTRAINT t_competency_pkey;
       nerielearning            testuser    false    219            �           2606    17301 (   t_curriculum_goal t_curriculum_goal_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT t_curriculum_goal_pkey PRIMARY KEY (curriculum_id);
 Y   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT t_curriculum_goal_pkey;
       nerielearning            testuser    false    221            �           2606    17456    t_lo_sa t_lo_sa_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY nerielearning.t_lo_sa
    ADD CONSTRAINT t_lo_sa_pkey PRIMARY KEY (lo_sa_code);
 E   ALTER TABLE ONLY nerielearning.t_lo_sa DROP CONSTRAINT t_lo_sa_pkey;
       nerielearning            testuser    false    222            k           2606    16614    m_class m_class_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.m_class
    ADD CONSTRAINT m_class_pkey PRIMARY KEY (class_code);
 >   ALTER TABLE ONLY public.m_class DROP CONSTRAINT m_class_pkey;
       public            testuser    false    201            o           2606    16681 $   m_class_subject m_class_subject_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.m_class_subject
    ADD CONSTRAINT m_class_subject_pkey PRIMARY KEY (csid);
 N   ALTER TABLE ONLY public.m_class_subject DROP CONSTRAINT m_class_subject_pkey;
       public            testuser    false    209            w           2606    16843 "   m_competencies m_competencies_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.m_competencies
    ADD CONSTRAINT m_competencies_pkey PRIMARY KEY (competencies_code);
 L   ALTER TABLE ONLY public.m_competencies DROP CONSTRAINT m_competencies_pkey;
       public            testuser    false    214            s           2606    16713 (   m_curriculum_goal m_curriculum_goal_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.m_curriculum_goal
    ADD CONSTRAINT m_curriculum_goal_pkey PRIMARY KEY (curriculum_code);
 R   ALTER TABLE ONLY public.m_curriculum_goal DROP CONSTRAINT m_curriculum_goal_pkey;
       public            testuser    false    212            u           2606    16718 *   m_learning_outcome m_learning_outcome_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.m_learning_outcome
    ADD CONSTRAINT m_learning_outcome_pkey PRIMARY KEY (loutcome_code);
 T   ALTER TABLE ONLY public.m_learning_outcome DROP CONSTRAINT m_learning_outcome_pkey;
       public            testuser    false    213            m           2606    16634    m_stage m_stage_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.m_stage
    ADD CONSTRAINT m_stage_pkey PRIMARY KEY (stage_code);
 >   ALTER TABLE ONLY public.m_stage DROP CONSTRAINT m_stage_pkey;
       public            testuser    false    202            q           2606    16698    m_subject m_subject_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.m_subject
    ADD CONSTRAINT m_subject_pkey PRIMARY KEY (subject_code);
 B   ALTER TABLE ONLY public.m_subject DROP CONSTRAINT m_subject_pkey;
       public            testuser    false    211            �           2606    17317 -   t_curriculum_goal fk3mw14v7mqbm7hx9scc6euwpec    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT fk3mw14v7mqbm7hx9scc6euwpec FOREIGN KEY (subject_code) REFERENCES nerielearning.m_subject(subject_code);
 ^   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT fk3mw14v7mqbm7hx9scc6euwpec;
       nerielearning          testuser    false    218    2943    221            �           2606    17457 "   t_lo_sa fk5p8gnphpa87pwt21ci3lw0dk    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_lo_sa
    ADD CONSTRAINT fk5p8gnphpa87pwt21ci3lw0dk FOREIGN KEY (t_competency_id) REFERENCES nerielearning.t_competency(t_competency_id);
 S   ALTER TABLE ONLY nerielearning.t_lo_sa DROP CONSTRAINT fk5p8gnphpa87pwt21ci3lw0dk;
       nerielearning          testuser    false    222    2945    219            �           2606    17302 (   t_competency fk9al5mlta5g2objoa4wa4888cd    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_competency
    ADD CONSTRAINT fk9al5mlta5g2objoa4wa4888cd FOREIGN KEY (curriculum_id) REFERENCES nerielearning.t_curriculum_goal(curriculum_id);
 Y   ALTER TABLE ONLY nerielearning.t_competency DROP CONSTRAINT fk9al5mlta5g2objoa4wa4888cd;
       nerielearning          testuser    false    2949    221    219            �           2606    17200 #   m_class fkbp07mfjqggnw0prtvj98tytvf    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.m_class
    ADD CONSTRAINT fkbp07mfjqggnw0prtvj98tytvf FOREIGN KEY (stage_code_stage_code) REFERENCES nerielearning.m_stage(stage_code);
 T   ALTER TABLE ONLY nerielearning.m_class DROP CONSTRAINT fkbp07mfjqggnw0prtvj98tytvf;
       nerielearning          testuser    false    215    2941    217            �           2606    17307 -   t_curriculum_goal fkityvv73r5offy3aiamxihwha2    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT fkityvv73r5offy3aiamxihwha2 FOREIGN KEY (class_code) REFERENCES nerielearning.m_class(class_code);
 ^   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT fkityvv73r5offy3aiamxihwha2;
       nerielearning          testuser    false    2937    215    221            �           2606    17312 -   t_curriculum_goal fkjhidbv2as6smh7fswn69ldqdw    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT fkjhidbv2as6smh7fswn69ldqdw FOREIGN KEY (goal_id) REFERENCES nerielearning.m_goal(goal_id);
 ^   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT fkjhidbv2as6smh7fswn69ldqdw;
       nerielearning          testuser    false    221    2939    216            �           2606    17289 (   t_competency fknodiga100wi4xdivn019jdykx    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_competency
    ADD CONSTRAINT fknodiga100wi4xdivn019jdykx FOREIGN KEY (competency_id) REFERENCES nerielearning.m_competency(competency_id);
 Y   ALTER TABLE ONLY nerielearning.t_competency DROP CONSTRAINT fknodiga100wi4xdivn019jdykx;
       nerielearning          testuser    false    220    2947    219            �           2606    17444 %   m_subject fkqs7l9mdmfhy03wjefmj6itut3    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.m_subject
    ADD CONSTRAINT fkqs7l9mdmfhy03wjefmj6itut3 FOREIGN KEY (class_code_class_code) REFERENCES nerielearning.m_class(class_code);
 V   ALTER TABLE ONLY nerielearning.m_subject DROP CONSTRAINT fkqs7l9mdmfhy03wjefmj6itut3;
       nerielearning          testuser    false    2937    218    215            �           2606    16699 +   m_class_subject fk5mjxfwqfttgn39c4htlmjlleq    FK CONSTRAINT     �   ALTER TABLE ONLY public.m_class_subject
    ADD CONSTRAINT fk5mjxfwqfttgn39c4htlmjlleq FOREIGN KEY (subject_code) REFERENCES public.m_subject(subject_code);
 U   ALTER TABLE ONLY public.m_class_subject DROP CONSTRAINT fk5mjxfwqfttgn39c4htlmjlleq;
       public          testuser    false    209    2929    211            �           2606    16652 #   m_class fkbp07mfjqggnw0prtvj98tytvf    FK CONSTRAINT     �   ALTER TABLE ONLY public.m_class
    ADD CONSTRAINT fkbp07mfjqggnw0prtvj98tytvf FOREIGN KEY (stage_code_stage_code) REFERENCES public.m_stage(stage_code);
 M   ALTER TABLE ONLY public.m_class DROP CONSTRAINT fkbp07mfjqggnw0prtvj98tytvf;
       public          testuser    false    201    2925    202            �           2606    16844 *   m_competencies fkg5lti9xfy5taxdy064lyv2obu    FK CONSTRAINT     �   ALTER TABLE ONLY public.m_competencies
    ADD CONSTRAINT fkg5lti9xfy5taxdy064lyv2obu FOREIGN KEY (curriculum_code) REFERENCES public.m_curriculum_goal(curriculum_code);
 T   ALTER TABLE ONLY public.m_competencies DROP CONSTRAINT fkg5lti9xfy5taxdy064lyv2obu;
       public          testuser    false    212    2931    214            �           2606    16684 +   m_class_subject fkr96ofy8iwk57pnvtcl01po2qt    FK CONSTRAINT     �   ALTER TABLE ONLY public.m_class_subject
    ADD CONSTRAINT fkr96ofy8iwk57pnvtcl01po2qt FOREIGN KEY (class_code) REFERENCES public.m_class(class_code);
 U   ALTER TABLE ONLY public.m_class_subject DROP CONSTRAINT fkr96ofy8iwk57pnvtcl01po2qt;
       public          testuser    false    201    209    2923            �           2606    16849 .   m_learning_outcome fkt0s4c6n1i8nq289e7l6uqdc3k    FK CONSTRAINT     �   ALTER TABLE ONLY public.m_learning_outcome
    ADD CONSTRAINT fkt0s4c6n1i8nq289e7l6uqdc3k FOREIGN KEY (competencies_code_competencies_code) REFERENCES public.m_competencies(competencies_code);
 X   ALTER TABLE ONLY public.m_learning_outcome DROP CONSTRAINT fkt0s4c6n1i8nq289e7l6uqdc3k;
       public          testuser    false    213    2935    214            %   V   x��9�@C�:>'�YZh����9p��W�v>4¥ː!�]w�S�}�0ǔ].�r�a6Ŭ�bU�b[��ZտJK�v��x ���      *   L  x�-ӻ�!DQ[7���2��P�q�md��nm�����6�5\�6HmRڢ���F;��B����&�	�v��!;�d�P��}��a������}�	���X���X	����6������݄{.8B�)$^B�-4~���0�z�E|��0��)�D
I�PDM�#�^p�_�n:M0�'C�0�$K(��&�p��Z/��/�7]&�S!�½%�BSG8�C�\��>7�&��!�B�%ܛ�B�G8��Y/�8_zn��`�BpRHN	�i���#�ì\̗��Ǟ��'g�)�|J����f��}9�����?������*      &   V   x�̹BA�����}b���:xN�����+����Ψfu���]ݜ��V/>�=hV`�v��0N��Pn��p^Z���{W�Y      '   G   x�3�t�/�KI,���K��2�(J-H,J,�/��2���LI�I�2�NM�*
�rzd�g�) �b���� ���      (   `   x�3��I�K/MLOU0T�p�K��,���4�2BH)h8攤�%�d��* )2��M,�H�J$+���&Y�y@32\����2��,�=... Y:8(      )   �  x��WM��6=ӿ��]�V#yw���vQ �\��^hil1K�*I�����!%���4i7E��B�83o��K�zO�l�݆|�C�v'cK�7���^��d�~���I�m���6Z�QJ�c��-�ꡯ�*RH���(�3IꞼ���wf��u�����񄣇�eFD�jyg�!��f=�&�X�e�=��4��f��x'JQ.�s�dq���Ys�j�֫:jg{�(�ߍޒ�C�J���_�!&���1{Ȯi\��7��hK��8���ģ������Z�m ��b�L���b�t=�c���F�9ۺ�ˍ
�>?O�����̞���{�1���o  ր|%nu��>U
�����B��f���6�6��3d"F�@9��5ͩ�hO�����{=$�;�WHGu�R��v�^��ީ�J��7Ϊ�֧��xq�8\�E��Kc�Xe��+! �C�}n�����ݑ��RF�V��3� 
�!{�f@_��	 '^�3�? ��P���!U����vD �RT�����A�Ce����|�:��]�<���J��K�Q�����GDY�kq;�g��$�!��Gjٸ؎�:��A���9��៮�֟�J!*�u�4�tg�zya�'��Qw�e�P�r߀M�r�l��$�c�QD\x�JT��u9��L*[�i�����o�~Y������/������T�K�*��|%ޑ
oN�uv�r�|�D����0.�g�%&n���hJT�X/�R��d����Y���9����=��B�6ŋ�*�S�_���un��%U���n��Lѩ�k�T�J%?-�Ac� �q�H���qG�d����>_DTk�F��S°1����� �0���Դ���.�Kɸ1)�3~��Ky�q�%��Oo��.���U�wm��ޙ���+q��)c&<x{��b�R3ԩA��xh՞�	��$�!md����n�3͞��~N���3
�������X\���irg=S�sBr�gy��K��d��a�nć��po����<��S��2�1o�*�������ץ�Z����Q��Ӻ&�|�˞א!U=sţ�t��E>�����/_��t�dk���ԃ0յ��-[�&�D̒���u����Ζ����p��_�}��nص�:�|Ԛ�Ǖ|�|�C����:��`��6G�,��2���3V�K^��{&�����tg<������d0Bֲ�Ӂɗ+���7<�^�mqU�����b���*j�      +   :  x��T��1��_�26�>@� u�4���t����������kH�}H�pfH�n���,6-lR[�1\nIB:�V�m��:	9���T*��������X�ē���`�)�:2g���:��WMEv��@lr��z̭����L.Tm�j.A��js�^�|�ò�˧^W�Ud��e�_��#޿K��y��v�ӗd�QC�:o5�j`	n䔪̥�:��*�}Z�J�h�9Q^I*����\ȅ����6�]%����#���Jq��P6+6�J��ZɊfh�V��gmĪU��'V�ê�7>�d�U{@��i2p�ᙜ��M�� �4f&h�n�op2��.�eL_f��N�;�M�t?��2P/N�>��c[iԒ�_c�SN�:[��y��,��@�� ?��t��k8꬜�Yi�K�q;%i�h�Q�:�J�x���^_��2)F}/6ī��H���,�S��:�hy��Ҥ$`Ň���;�B�#�>M�S��l���Bhup��ި_8��M�Ù���V\@����f>Ԅ�\A:�&�c�~i��S�����~����}��      ,   �  x��XM��6=K���bU�+���܊l{
dQ��-�6c�TH�^���!)Y�8h.m�"�ƒəy��f�e��؝c��o�����ە���eo�a+�p�W}Ǽa���N����sՋ��g�ۍH�Y3��$j��ښڄ�����l�����;�����ѝ���(o�~���ee^�CF���_�g��$���h�A��d���Mzgڎۋ���M���w�গS�:u��q�6��~p�s-W
�Fu�Ms3v�>��G!��6�:H�]��_�e-�H����
�a��|c�z�kaҪ핗��5����np�]I^���l#�B'���.ӽR�O��g�٨=�v��pq	�*���f�D�R��A������H��r�'�Y!�����А1�U�>䒗�K-�=�*{��O�!ybO�5��[��p��́l�7p���!����R0CE�le7���C��i�m?8�w���%�+�a��&몂��(�]��
�zj����ʲ'��t�e^�~
���ͬ`�;�!�`���Eq_<� f3��<�B���1���9�K�����"u�"�&q�%r/�I7T|��!�nܖېİc-u`,:f�����P��SA��n�!�V/�~��M���s*z����se���j�?G�0l�AYe�(�9ALm ����:��Y�C��4�������Ѱ<�:ar!(yZ���T"�(��"����E��ý���5q�@����0ˌ��E�����O��R�A��e`ǽ�M	B"��C��%8��а�����R~(ʲ(�rY�$�&��06I+��l#=Ø�:���e+��E^�3^�%5M�>8�y��_Q�TO��]%�\Kc#S=�IPV>XX���"=׽.�͖5h8+�"���#j��z����=�Fg3�f{.��x��=HK��./ߎ���r���u]�w��j�b$�͕{�U!j$&6e��1;܄��60P�8��$��@�Ѭ �X	\���γ�=۸���|��n
!)+�h�[��QL���}���T{�dN!�W���6lûqhA�)1�����>]����{���4�c�Qߣ�R'N��ׂwW�΅��T �
+v��ԅCⴐgCb����"�g�vV�"�H�ޙ���+Zo%�.Y�_K[�\�C���jn�����>/&��C^>N�r����ST�=E�C ��"@�Z����cɢ���1�S_��x+��1 ���s�1n�&�4��>~��ϕ6&���i�2�n3,��$���PNNz�fb�j�/��O�H���p���MZK�'�<a��0��QS���M�͋� �I6���	��m^��Ǜ�a�OI��5�E�5���)εc�f <�>�!�L�2��Bp����}�Ͳ��|��"��b�Ν���:��x�5-Ů̫��[�W�	���n��"�]ݍb/�{�I���N*���4�qE���p��+�SǍ��1��Y"4��%
���q�մ�}��a�v�~ݡ�މȧIHj#�]^=\�� K��B!D?M����;���1H�Ĩ9NK�;ް5�|L[��B��s�#!&9��_�*b2H���>^3!7L�6Vr�ٚxJ٧~�~t���UOH�p�#���6� �#�~�I`k�1�;�xmp�r�����v�������c��,�� )\\         V   x��9�@C�:>'�YZh����9p��W�v>4¥ː!�]w�S�}�0ǔ].�r�a6Ŭ�bU�b[��ZտJK�v��x ���         2   x���  �ޤgV����:�OB(-=4����*'֗٪�/s� �m-      $   h  x��VM��6=˿��]�v��l���vQ �\��^hjl1K�*I������_�7CI�:NЋ!����͛!7�G�"%�9)߷[�I�������iC��v=��corI������V��K�S��.���X�)���TN��)e=��49��v:��>�	�ǆ}D��k���1ɓA�H����r�xRN��䷮6��y��<��C�;�^��.j�m����⻳;R7�7��I}�w����T����? J�Ľ�� f�I�`t	&z��4���l*�2���}�vg�2�+�ۡ  ާ�BGq�!!��ف�]���d��
H^�Q9�܁�v1l��u�h�	�{o�PS2�n�j��L�F;m�M��M��wd/����t ~K�������G�	���/�W%�6�F�'�Z���6xm����0c񬲡^��Q��Z�\��a%��&�jے�6i�R�;*d׀��q@��=w�#-�g���C�uu�x3o.���ց?]��s��2��@��GQ����y��Do�ǱS�"%a��"P�|r3����{�;�R�c�k�z��q��v�� ��՝���KD'�8�e$�0��~�bx��tj[ʠ�&�Α��JQ�<�;�ZguTw��z�8���|E��?��J�o��@:��
9>��T�c-��}�&�,�rz���뺺_l6���&^���V���0'�gR��Ck�Z�U��YR���,J<��"YN�(�2,C�d���:Z�g ����b�Bes��h�!���C��A	���x�-sbh��}n��a�)20����g�IfǷҶ[ ������)���[�XtT�F����FI�MN2$9u�a�vy�&����|g&WHd��p�޷�LAF�J)��嬢A6?Z�����T����n\k�cNV�	'x�������ʺz�ؼ�>Osz�j�oB�&aE�^�E���3j�+T[]��(%~|� ����c�L�ֳ1!�Lk����ld����|�ֆ=/�r��ܺ�u:N��}����.��!�V�ch�	�9�}�e���'<ߠʠ��+Y�+�\���	\⸉~�����p9&,��F`}jm�=��� �������b��e9�/      "     x�USK��0]ǧв<�;@�n]w׍"�gdI)��KJn�l�X�����t�'(�6Ndb]o�b>�T#c\'rm�bc��q4r��dv�<
+)�=��8��&��l6T0t�:���vv�2�r�Ωs��Τ�6V�#�g���'$��*��D�K�l���0*Dt>_�G�B�tު?(H����E�I��I���	W�$�l0���Z�6K1ep8+,$w�oJ�\�[��c���c>�TW˦�eE���-o7sU��:|y�
�j�7�I�]�?���q搜kD�>��\K8�T�?ہ��Q�t�N}��i�t
��`4��~4�%�.^�V|�fK��й�__���K�o��./M����6)�Jo+��)��1�s9��I�3��1�4-�#���\�z�MX��>'��0gxPt�rgEd鵋$)�Z�ޥ5Wn3���1���u�v���öY>�m��	�H5fY�s�u�R]��u�O�K��O����T�7�ٶ�.�s����0���k�      #   9  x��U=��6��S�ʗ|�x����Ա]�H�4�@���"����r�&�Mr���fw�^׮��G<�= o�����������"�i�)D�FH�L�]�ņ��v"et�~�È�̀�HG�0?�#�����i��?�Jo��ޞ.�0Z��>��`��4ĥl[N,h��8�)`S�$�{N/u=r:������Q�V/��'�������@��V���ԤY�)JqB ��&-7X�v�_��Pj���"��W�Y���[`w�'r�Jl�<{%|��`@k?9�	��=�LD�o�Н�AJ��#���EϚ�����S"')GL�������"��hs��%��c�qf��ûx�QN�� ��۶�Z�͔R����V�����}�)rL��J͍�jcTK�	\�$�$c�ue!�TW���rosa-c��x�Dz��eU�<"��y�#F؜�6Wp�ѿB��*�e� ����z�%<e>�C���pBb[2���2N��6����f���)�~Gf�A����x�t�a���Yr�2�-ǄN��,�|� ��X���LFn�@)G�Z�)_�;����cT�V�;���d�Q�hs�a��2��ns��ZW�6���$s,@��K�V����[��9�[?ߖ��j��u+����-;xa��$&�Cg��. ef�v��y5���pz��r�Q�2�.!���������5�Y��t�+�����p�wb.����$t�	r��W����?'�p6��2�,�0�8o�X�<4�����ZtS���Z�9�I��$ �o�<��:�Ke3���l�.R�_�$����?H��������+         G   x�3�t�/�KI,���K��2�(J-H,J,�/��2���LI�I�2�NM�*
�rzd�g�) �b���� ���      !   M   x�3��I�K/MLOU0T�p�K��,���2B)h8攤�%�d��*��s�&�d�����\SJ����<�=... ���     