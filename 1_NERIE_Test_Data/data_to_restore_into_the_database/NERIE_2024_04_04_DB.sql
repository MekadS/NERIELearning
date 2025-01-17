PGDMP                         |            NERIELearningAppDB    13.12    13.12 -    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16608    NERIELearningAppDB    DATABASE     p   CREATE DATABASE "NERIELearningAppDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
 $   DROP DATABASE "NERIELearningAppDB";
                testuser    false                        2615    17055    nerielearning    SCHEMA        CREATE SCHEMA nerielearning;
    DROP SCHEMA nerielearning;
                testuser    false            �            1259    17151    m_class    TABLE     �   CREATE TABLE nerielearning.m_class (
    class_code bigint NOT NULL,
    class_name character varying(255),
    stage_code_stage_code bigint,
    stage_code_stage_id bigint,
    stage_id_stage_id bigint
);
 "   DROP TABLE nerielearning.m_class;
       nerielearning         heap    testuser    false    4            �            1259    17462    m_class_seq    SEQUENCE     |   CREATE SEQUENCE nerielearning.m_class_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE nerielearning.m_class_seq;
       nerielearning          testuser    false    4            �            1259    17284    m_competency    TABLE     �   CREATE TABLE nerielearning.m_competency (
    competency_id character varying(255) NOT NULL,
    competency_code character varying(10)
);
 '   DROP TABLE nerielearning.m_competency;
       nerielearning         heap    testuser    false    4            �            1259    17177    m_goal    TABLE     x   CREATE TABLE nerielearning.m_goal (
    goal_id character varying(255) NOT NULL,
    goal_code character varying(10)
);
 !   DROP TABLE nerielearning.m_goal;
       nerielearning         heap    testuser    false    4            �            1259    17182    m_stage    TABLE     n   CREATE TABLE nerielearning.m_stage (
    stage_code bigint NOT NULL,
    stage_name character varying(255)
);
 "   DROP TABLE nerielearning.m_stage;
       nerielearning         heap    testuser    false    4            �            1259    17464    m_stage_seq    SEQUENCE     |   CREATE SEQUENCE nerielearning.m_stage_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE nerielearning.m_stage_seq;
       nerielearning          testuser    false    4            �            1259    17187 	   m_subject    TABLE     �   CREATE TABLE nerielearning.m_subject (
    subject_code bigint NOT NULL,
    subject_name character varying(255),
    class_code_class_code bigint
);
 $   DROP TABLE nerielearning.m_subject;
       nerielearning         heap    testuser    false    4            �            1259    17466    m_subject_seq    SEQUENCE     ~   CREATE SEQUENCE nerielearning.m_subject_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE nerielearning.m_subject_seq;
       nerielearning          testuser    false    4            �            1259    17251    t_competency    TABLE     '  CREATE TABLE nerielearning.t_competency (
    t_competency_id character varying(255) NOT NULL,
    competency_description character varying(1000) NOT NULL,
    competency_name character varying(150) NOT NULL,
    competency_id character varying(255),
    curriculum_id character varying(255)
);
 '   DROP TABLE nerielearning.t_competency;
       nerielearning         heap    testuser    false    4            �            1259    17294    t_curriculum_goal    TABLE       CREATE TABLE nerielearning.t_curriculum_goal (
    curriculum_id character varying(255) NOT NULL,
    curriculum_description character varying(1000),
    curriculum_name character varying(150),
    class_code bigint,
    goal_id character varying(255),
    subject_code bigint
);
 ,   DROP TABLE nerielearning.t_curriculum_goal;
       nerielearning         heap    testuser    false    4            �            1259    17449    t_lo_sa    TABLE     �   CREATE TABLE nerielearning.t_lo_sa (
    lo_sa_code character varying(255) NOT NULL,
    learning_outcome character varying(1000),
    suggestive_activity character varying(1000),
    t_competency_id character varying(255)
);
 "   DROP TABLE nerielearning.t_lo_sa;
       nerielearning         heap    testuser    false    4            �          0    17151    m_class 
   TABLE DATA              COPY nerielearning.m_class (class_code, class_name, stage_code_stage_code, stage_code_stage_id, stage_id_stage_id) FROM stdin;
    nerielearning          testuser    false    200   {:       �          0    17284    m_competency 
   TABLE DATA           M   COPY nerielearning.m_competency (competency_id, competency_code) FROM stdin;
    nerielearning          testuser    false    205   �:       �          0    17177    m_goal 
   TABLE DATA           ;   COPY nerielearning.m_goal (goal_id, goal_code) FROM stdin;
    nerielearning          testuser    false    201   H<       �          0    17182    m_stage 
   TABLE DATA           @   COPY nerielearning.m_stage (stage_code, stage_name) FROM stdin;
    nerielearning          testuser    false    202   �<       �          0    17187 	   m_subject 
   TABLE DATA           ]   COPY nerielearning.m_subject (subject_code, subject_name, class_code_class_code) FROM stdin;
    nerielearning          testuser    false    203   =       �          0    17251    t_competency 
   TABLE DATA           �   COPY nerielearning.t_competency (t_competency_id, competency_description, competency_name, competency_id, curriculum_id) FROM stdin;
    nerielearning          testuser    false    204   u=       �          0    17294    t_curriculum_goal 
   TABLE DATA           �   COPY nerielearning.t_curriculum_goal (curriculum_id, curriculum_description, curriculum_name, class_code, goal_id, subject_code) FROM stdin;
    nerielearning          testuser    false    206   iB       �          0    17449    t_lo_sa 
   TABLE DATA           l   COPY nerielearning.t_lo_sa (lo_sa_code, learning_outcome, suggestive_activity, t_competency_id) FROM stdin;
    nerielearning          testuser    false    207   ,E       �           0    0    m_class_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('nerielearning.m_class_seq', 1, false);
          nerielearning          testuser    false    208            �           0    0    m_stage_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('nerielearning.m_stage_seq', 1, false);
          nerielearning          testuser    false    209            �           0    0    m_subject_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('nerielearning.m_subject_seq', 1, false);
          nerielearning          testuser    false    210            F           2606    17155    m_class m_class_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY nerielearning.m_class
    ADD CONSTRAINT m_class_pkey PRIMARY KEY (class_code);
 E   ALTER TABLE ONLY nerielearning.m_class DROP CONSTRAINT m_class_pkey;
       nerielearning            testuser    false    200            P           2606    17288    m_competency m_competency_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY nerielearning.m_competency
    ADD CONSTRAINT m_competency_pkey PRIMARY KEY (competency_id);
 O   ALTER TABLE ONLY nerielearning.m_competency DROP CONSTRAINT m_competency_pkey;
       nerielearning            testuser    false    205            H           2606    17181    m_goal m_goal_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY nerielearning.m_goal
    ADD CONSTRAINT m_goal_pkey PRIMARY KEY (goal_id);
 C   ALTER TABLE ONLY nerielearning.m_goal DROP CONSTRAINT m_goal_pkey;
       nerielearning            testuser    false    201            J           2606    17186    m_stage m_stage_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY nerielearning.m_stage
    ADD CONSTRAINT m_stage_pkey PRIMARY KEY (stage_code);
 E   ALTER TABLE ONLY nerielearning.m_stage DROP CONSTRAINT m_stage_pkey;
       nerielearning            testuser    false    202            L           2606    17191    m_subject m_subject_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY nerielearning.m_subject
    ADD CONSTRAINT m_subject_pkey PRIMARY KEY (subject_code);
 I   ALTER TABLE ONLY nerielearning.m_subject DROP CONSTRAINT m_subject_pkey;
       nerielearning            testuser    false    203            N           2606    17258    t_competency t_competency_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY nerielearning.t_competency
    ADD CONSTRAINT t_competency_pkey PRIMARY KEY (t_competency_id);
 O   ALTER TABLE ONLY nerielearning.t_competency DROP CONSTRAINT t_competency_pkey;
       nerielearning            testuser    false    204            R           2606    17301 (   t_curriculum_goal t_curriculum_goal_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT t_curriculum_goal_pkey PRIMARY KEY (curriculum_id);
 Y   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT t_curriculum_goal_pkey;
       nerielearning            testuser    false    206            T           2606    17456    t_lo_sa t_lo_sa_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY nerielearning.t_lo_sa
    ADD CONSTRAINT t_lo_sa_pkey PRIMARY KEY (lo_sa_code);
 E   ALTER TABLE ONLY nerielearning.t_lo_sa DROP CONSTRAINT t_lo_sa_pkey;
       nerielearning            testuser    false    207            ]           2606    17317 -   t_curriculum_goal fk3mw14v7mqbm7hx9scc6euwpec    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT fk3mw14v7mqbm7hx9scc6euwpec FOREIGN KEY (subject_code) REFERENCES nerielearning.m_subject(subject_code);
 ^   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT fk3mw14v7mqbm7hx9scc6euwpec;
       nerielearning          testuser    false    206    203    2892            W           2606    17474 #   m_class fk4bq5us8phccfkhp6x1ux82eco    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.m_class
    ADD CONSTRAINT fk4bq5us8phccfkhp6x1ux82eco FOREIGN KEY (stage_id_stage_id) REFERENCES nerielearning.m_stage(stage_code);
 T   ALTER TABLE ONLY nerielearning.m_class DROP CONSTRAINT fk4bq5us8phccfkhp6x1ux82eco;
       nerielearning          testuser    false    202    2890    200            ^           2606    17457 "   t_lo_sa fk5p8gnphpa87pwt21ci3lw0dk    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_lo_sa
    ADD CONSTRAINT fk5p8gnphpa87pwt21ci3lw0dk FOREIGN KEY (t_competency_id) REFERENCES nerielearning.t_competency(t_competency_id);
 S   ALTER TABLE ONLY nerielearning.t_lo_sa DROP CONSTRAINT fk5p8gnphpa87pwt21ci3lw0dk;
       nerielearning          testuser    false    204    207    2894            Z           2606    17302 (   t_competency fk9al5mlta5g2objoa4wa4888cd    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_competency
    ADD CONSTRAINT fk9al5mlta5g2objoa4wa4888cd FOREIGN KEY (curriculum_id) REFERENCES nerielearning.t_curriculum_goal(curriculum_id);
 Y   ALTER TABLE ONLY nerielearning.t_competency DROP CONSTRAINT fk9al5mlta5g2objoa4wa4888cd;
       nerielearning          testuser    false    206    2898    204            V           2606    17469 #   m_class fk9dy8ji0jeityctnwtkcquskik    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.m_class
    ADD CONSTRAINT fk9dy8ji0jeityctnwtkcquskik FOREIGN KEY (stage_code_stage_id) REFERENCES nerielearning.m_stage(stage_code);
 T   ALTER TABLE ONLY nerielearning.m_class DROP CONSTRAINT fk9dy8ji0jeityctnwtkcquskik;
       nerielearning          testuser    false    2890    202    200            U           2606    17200 #   m_class fkbp07mfjqggnw0prtvj98tytvf    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.m_class
    ADD CONSTRAINT fkbp07mfjqggnw0prtvj98tytvf FOREIGN KEY (stage_code_stage_code) REFERENCES nerielearning.m_stage(stage_code);
 T   ALTER TABLE ONLY nerielearning.m_class DROP CONSTRAINT fkbp07mfjqggnw0prtvj98tytvf;
       nerielearning          testuser    false    202    2890    200            [           2606    17307 -   t_curriculum_goal fkityvv73r5offy3aiamxihwha2    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT fkityvv73r5offy3aiamxihwha2 FOREIGN KEY (class_code) REFERENCES nerielearning.m_class(class_code);
 ^   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT fkityvv73r5offy3aiamxihwha2;
       nerielearning          testuser    false    200    2886    206            \           2606    17312 -   t_curriculum_goal fkjhidbv2as6smh7fswn69ldqdw    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_curriculum_goal
    ADD CONSTRAINT fkjhidbv2as6smh7fswn69ldqdw FOREIGN KEY (goal_id) REFERENCES nerielearning.m_goal(goal_id);
 ^   ALTER TABLE ONLY nerielearning.t_curriculum_goal DROP CONSTRAINT fkjhidbv2as6smh7fswn69ldqdw;
       nerielearning          testuser    false    201    2888    206            Y           2606    17289 (   t_competency fknodiga100wi4xdivn019jdykx    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.t_competency
    ADD CONSTRAINT fknodiga100wi4xdivn019jdykx FOREIGN KEY (competency_id) REFERENCES nerielearning.m_competency(competency_id);
 Y   ALTER TABLE ONLY nerielearning.t_competency DROP CONSTRAINT fknodiga100wi4xdivn019jdykx;
       nerielearning          testuser    false    205    2896    204            X           2606    17444 %   m_subject fkqs7l9mdmfhy03wjefmj6itut3    FK CONSTRAINT     �   ALTER TABLE ONLY nerielearning.m_subject
    ADD CONSTRAINT fkqs7l9mdmfhy03wjefmj6itut3 FOREIGN KEY (class_code_class_code) REFERENCES nerielearning.m_class(class_code);
 V   ALTER TABLE ONLY nerielearning.m_subject DROP CONSTRAINT fkqs7l9mdmfhy03wjefmj6itut3;
       nerielearning          testuser    false    200    203    2886            �   a   x�E�9
�0D�Z:L�,�m҆��|�sdl	�<�:_!���8BѤ��]�/3��)ť
%S���C�tIX�6g;�M���	��ل��q0��h*�      �   L  x�-ӻ�!DQ[7���2��P�q�md��nm�����6�5\�6HmRڢ���F;��B����&�	�v��!;�d�P��}��a������}�	���X���X	����6������݄{.8B�)$^B�-4~���0�z�E|��0��)�D
I�PDM�#�^p�_�n:M0�'C�0�$K(��&�p��Z/��/�7]&�S!�½%�BSG8�C�\��>7�&��!�B�%ܛ�B�G8��Y/�8_zn��`�BpRHN	�i���#�ì\̗��Ǟ��'g�)�|J����f��}9�����?������*      �   V   x�̹BA�����}b���:xN�����+����Ψfu���]ݜ��V/>�=hV`�v��0N��Pn��p^Z���{W�Y      �   G   x�3�t�/�KI,���K��2�(J-H,J,�/��2���LI�I�2�NM�*
�rzd�g�) �b���� ���      �   `   x�3��I�K/MLOU0T�p�K��,���4�2BH)h8攤�%�d��* )2��M,�H�J$+���&Y�y@32\����2��,�=... Y:8(      �   �  x��WM��6=ӿ��]�V#yw���vQ �\��^hil1K�*I�����!%���4i7E��B�83o��K�zO�l�݆|�C�v'cK�7���^��d�~���I�m���6Z�QJ�c��-�ꡯ�*RH���(�3IꞼ���wf��u�����񄣇�eFD�jyg�!��f=�&�X�e�=��4��f��x'JQ.�s�dq���Ys�j�֫:jg{�(�ߍޒ�C�J���_�!&���1{Ȯi\��7��hK��8���ģ������Z�m ��b�L���b�t=�c���F�9ۺ�ˍ
�>?O�����̞���{�1���o  ր|%nu��>U
�����B��f���6�6��3d"F�@9��5ͩ�hO�����{=$�;�WHGu�R��v�^��ީ�J��7Ϊ�֧��xq�8\�E��Kc�Xe��+! �C�}n�����ݑ��RF�V��3� 
�!{�f@_��	 '^�3�? ��P���!U����vD �RT�����A�Ce����|�:��]�<���J��K�Q�����GDY�kq;�g��$�!��Gjٸ؎�:��A���9��៮�֟�J!*�u�4�tg�zya�'��Qw�e�P�r߀M�r�l��$�c�QD\x�JT��u9��L*[�i�����o�~Y������/������T�K�*��|%ޑ
oN�uv�r�|�D����0.�g�%&n���hJT�X/�R��d����Y���9����=��B�6ŋ�*�S�_���un��%U���n��Lѩ�k�T�J%?-�Ac� �q�H���qG�d����>_DTk�F��S°1����� �0���Դ���.�Kɸ1)�3~��Ky�q�%��Oo��.���U�wm��ޙ���+q��)c&<x{��b�R3ԩA��xh՞�	��$�!md����n�3͞��~N���3
�������X\���irg=S�sBr�gy��K��d��a�nć��po����<��S��2�1o�*�������ץ�Z����Q��Ӻ&�|�˞א!U=sţ�t��E>�����/_��t�dk���ԃ0յ��-[�&�D̒���u����Ζ����p��_�}��nص�:�|Ԛ�Ǖ|�|�C����:��`��6G�,��2���3V�K^��{&�����tg<������d0Bֲ�Ӂɗ+���7<�^�mqU�����b���*j�      �   �  x��TM��0=���G����&�=��%��e�Lj/��Ѫ��yNB�^W�K?�7�O]|���vA�4�G��.٨��v�k�{�Q;^����9��A\�3|L!�E���4Y1�,�d�p��R��jfdI�k¥8��.yq���p#{������i�r��t�����g�NV?n��#S�%C���J�g	/vE]lWwŽ%s���JE9��Q�9g��y�T�"^�t�g�:=� $#N��J���ad���g�\�O*9H��S������J����Ll��3Ŝ1CGEQ(:�F��u����;X�}�����#Z��@N�3�;>��a�fL���4�"Lи0'�$�� K4Y�������0�\�ԗ\
��U)
@��>)�|*�ٙ4�\+��kf�l5�'�M��?��$~n�gS��37��:Cp�i��ژ�LH�ћ<��2��C�A Z�zL��&�2٘�ݑ6WatϷ3?�����#t��K7�)N	ب�����3�Bm�m�޺���X9RO�\jgo�_x�˦����I	�, ��;}2ل�A��M��P���~NU0n��@�f�l�j�Цj��:��T���o��+:�}�х��  ����	�0�hCJ|�#��u[4����PW�U/��k��:0�վ;6�S#����h�Z�v���IC���Û��>��x����j��s >      �   �  x��XM��6=K���bU�+���܊l{
dQ��-�6c�TH�^���!)Y�8h.m�"�ƒəy��f�e��؝c��o�����ە���eo�a+�p�W}Ǽa���N����sՋ��g�ۍH�Y3��$j��ښڄ�����l�����;�����ѝ���(o�~���ee^�CF���_�g��$���h�A��d���Mzgڎۋ���M���w�গS�:u��q�6��~p�s-W
�Fu�Ms3v�>��G!��6�:H�]��_�e-�H����
�a��|c�z�kaҪ핗��5����np�]I^���l#�B'���.ӽR�O��g�٨=�v��pq	�*���f�D�R��A������H��r�'�Y!�����А1�U�>䒗�K-�=�*{��O�!ybO�5��[��p��́l�7p���!����R0CE�le7���C��i�m?8�w���%�+�a��&몂��(�]��
�zj����ʲ'��t�e^�~
���ͬ`�;�!�`���Eq_<� f3��<�B���1���9�K�����"u�"�&q�%r/�I7T|��!�nܖېİc-u`,:f�����P��SA��n�!�V/�~��M���s*z����se���j�?G�0l�AYe�(�9ALm ����:��Y�C��4�������Ѱ<�:ar!(yZ���T"�(��"����E��ý���5q�@����0ˌ��E�����O��R�A��e`ǽ�M	B"��C��%8��а�����R~(ʲ(�rY�$�&��06I+��l#=Ø�:���e+��E^�3^�%5M�>8�y��_Q�TO��]%�\Kc#S=�IPV>XX���"=׽.�͖5h8+�"���#j��z����=�Fg3�f{.��x��=HK��./ߎ���r���u]�w��j�b$�͕{�U!j$&6e��1;܄��60P�8��$��@�Ѭ �X	\���γ�=۸���|��n
!)+�h�[��QL���}���T{�dN!�W���6lûqhA�)1�����>]����{���4�c�Qߣ�R'N��ׂwW�΅��T �
+v��ԅCⴐgCb����"�g�vV�"�H�ޙ���+Zo%�.Y�_K[�\�C���jn�����>/&��C^>N�r����ST�=E�C ��"@�Z����cɢ���1�S_��x+��1 ���s�1n�&�4��>~��ϕ6&���i�2�n3,��$���PNNz�fb�j�/��O�H���p���MZK�'�<a��0��QS���M�͋� �I6���	��m^��Ǜ�a�OI��5�E�5���)εc�f <�>�!�L�2��Bp����}�Ͳ��|��"��b�Ν���:��x�5-Ů̫��[�W�	���n��"�]ݍb/�{�I���N*���4�qE���p��+�SǍ��1��Y"4��%
���q�մ�}��a�v�~ݡ�މȧIHj#�]^=\�� K��B!D?M����;���1H�Ĩ9NK�;ް5�|L[��B��s�#!&9��_�*b2H���>^3!7L�6Vr�ٚxJ٧~�~t���UOH�p�#���6� �#�~�I`k�1�;�xmp�r�����v�������c��,�� )\\     