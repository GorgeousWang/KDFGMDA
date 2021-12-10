# KDFGMDA

#### Abstract
Motivation: increasing biological evidence indicated that miRNAs play a vital role in exploring the pathogenesis of various human diseases (especially in tumors). Mining disease-related miRNAs is of great significance for the clinical diagnosis and treatment of diseases. Compared with the traditional experimental methods with the significant limitations of high cost, long cycle and small scale,  the methods based on computing has the advantages of cost-effective. However, although the current methods based on computational biology can accurately predict the correlation between miRNAs and disease, they can not predict the detailed association information at a fine level.
Results: we propose a knowledge driven approach to fine-grained prediction of disease-related miRNAs(KDFGMDA). Different from the previous methods, this method can finely predict the clear associations between miRNA and disease, such as upregulation(UR), downregulation(DR) or dysregulation(SR). Specifically, KDFGMDA extracts triple information from massive experimental data and existing datasets to construct a knowledge graph, and then trains a depth graph representation learning model based on knowledge graph to complete fine-grained prediction tasks. Experimental results show that KDFGMDA can predict the relationship between miRNA and disease accurately, which is of far-reaching significance for medical clinical research and early diagnosis, prevention and treatment of diseases. Additionally, case study on three type cancers further provide the effectiveness and feasibility of KGFGMDA to detect potential candidate miRNAs.

#### Framework and Results
##framework
![输入图片说明](flowchat.png)

##Results
![输入图片说明](performance.png)



Cohort	英文名称	中文名称
TCGA-ACC	Adrenocortical carcinoma	肾上腺皮质癌
TCGA-BLCA	Bladder Urothelial Carcinoma	膀胱尿路上皮癌
TCGA-BRCA	Breast invasive carcinoma	乳腺浸润癌
TCGA-CESC	Cervical squamous cell carcinoma and endocervical adenocarcinoma	宫颈鳞癌和腺癌
TCGA-CHOL	Cholangiocarcinoma	胆管癌
TCGA-COAD	Colon adenocarcinoma	结肠癌
TCGA-COADREAD	Colon adenocarcinoma/Rectum adenocarcinoma Esophageal carcinoma	结直肠癌
TCGA-DLBC	Lymphoid Neoplasm Diffuse Large B-cell Lymphoma	弥漫性大B细胞淋巴瘤
TCGA-ESCA	Esophageal carcinoma	食管癌
TCGA-FPPP	FFPE Pilot Phase II	FFPE试点二期
TCGA-GBM	Glioblastoma multiforme	多形成性胶质细胞瘤
TCGA-GBMLGG	Glioma	胶质瘤
TCGA-HNSC	Head and Neck squamous cell carcinoma	头颈鳞状细胞癌
TCGA-KICH	Kidney Chromophobe	肾嫌色细胞癌
TCGA-KIPAN	Pan-kidney cohort (KICH+KIRC+KIRP)	混合肾癌
TCGA-KIRC	Kidney renal clear cell carcinoma	肾透明细胞癌
TCGA-KIRP	Kidney renal papillary cell carcinoma	肾乳头状细胞癌
TCGA-LAML	Acute Myeloid Leukemia	急性髓细胞样白血病
TCGA-LGG	Brain Lower Grade Glioma	脑低级别胶质瘤
TCGA-LIHC	Liver hepatocellular carcinoma	肝细胞肝癌
TCGA-LUAD	Lung adenocarcinoma	肺腺癌
TCGA-LUSC	Lung squamous cell carcinoma	肺鳞癌
TCGA-MESO	Mesothelioma	间皮瘤
TCGA-OV	        Ovarian serous cystadenocarcinoma	卵巢浆液性囊腺癌
TCGA-PAAD	Pancreatic adenocarcinoma	胰腺癌
TCGA-PCPG	Pheochromocytoma and Paraganglioma	嗜铬细胞瘤和副神经节瘤
TCGA-PRAD	Prostate adenocarcinoma	前列腺癌
TCGA-READ	Rectum adenocarcinoma	直肠腺癌
TCGA-SARC	Sarcoma	肉瘤
TCGA-STAD	Stomach adenocarcinoma	胃癌
TCGA-SKCM	Skin Cutaneous Melanoma	黑色素瘤
TCGA-STES	Stomach and Esophageal carcinoma	胃和食管癌
TCGA-TGCT	Testicular Germ Cell Tumors	睾丸癌
TCGA-THCA	Thyroid carcinoma	甲状腺癌
TCGA-THYM	Thymoma	胸腺癌
TCGA-UCEC	Uterine Corpus Endometrial Carcinoma	子宫内膜癌
TCGA-UCS	Uterine Carcinosarcoma	子宫肉瘤
TCGA-UVM	Uveal Melanoma	葡萄膜黑色素瘤
TARGET-OS	Osteosarcoma	骨肉瘤
TARGET-ALL	Acute Lymphoblastic Leukemia	白血病
TARGET-NB	Neuroblastoma	神经母细胞瘤
TARGET-WT	High-Risk Wilms Tumor	肾母细胞瘤

