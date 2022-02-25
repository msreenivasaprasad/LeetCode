import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DS_Count_Words_Obtained_After_Adding_a_Letter {
	public static void main(String[] args) {
		String[] startWords = { "mgxfkirslbh", "wpmsq", "pxfouenr", "lnq", "vcomefldanb", "gdsjz", "xortwlsgevidjpc",
				"kynjtdlpg", "hmofavtbgykidw", "bsefprtwxuamjih", "yvuxreobngjp", "ihbywqkteusjxl", "ugh",
				"auydixmtogrkve", "ox", "wvknsj", "pyekgfcab", "zsunrh", "ecrpmxuw", "mtvpdgwr", "kpbmwlxgus", "ob",
				"gfhqz", "qvjkgtxecdoafpi", "rnufgtom", "vijqecrny", "lkgtqcxbrfhay", "eq", "mbhf", "iv", "bzevwoxrnjp",
				"wgusokd", "cnkexvsquwlgbfp", "zebrwf", "gdxleczutofajir", "x", "mtraowpeschbkxi", "daickygrp", "p",
				"xjlwcbapyszdtv", "hgab", "nlgf", "z", "mt", "oumqabs", "alf", "whfruolazjdcb", "tf", "dxngwmft",
				"ibuvnosrqdgjyp", "hftpg", "jcnah", "recavwlgfxiuk", "stjuiedvlfwbhpq", "dqakvgfrc", "nzqtouwbism",
				"dwymhgcsx", "zvqr", "c", "hevgr", "jbsvmrtcnow", "fptlcxg", "wsiqcgnlfxb", "zapnjquycdsxvi", "lcvabg",
				"hpuzsbgqkeixwr", "ornd", "eqgukchjnwids", "ysxbhdzpvgcew", "ji", "ozna", "be", "muhikqnd",
				"axlhyftvrpkucs", "aedofvlhzqmxrt", "g", "leifus", "i", "qlgcrxsdnmytb", "t", "fbhlgrvozsyxajt",
				"puyqhksclinob", "vfbpcedhn", "nqism", "zi", "qgb", "qweg", "sh", "qmbunh", "sp", "cainjebqmvyslo",
				"hya", "ifyrxkgemqc", "hmcrgabdlqkfs", "o", "abikmjqpr", "hbzedog", "yxijqknhl", "g", "jhbav", "n",
				"bvglmordite", "r", "ulmkqdwytxipvao", "ngfkuvxatzqryl", "wzmxuiyj", "jguv", "vzgmelrnjpsoa",
				"lgndsxvuiq", "cflwyxbezdgsqj", "tiqznalvrdepws", "znofuykwilps", "srquzgomnlkcb", "fuktdpbinwl",
				"bevucxl", "zgxahrynjqfsmu", "digtkmachbrxven", "zlkpqatvibr", "awdilqtmbrvceg", "oswhbncfx",
				"ruzqfvtjphg", "x", "i", "cydkbxnl", "zprdiwholgm", "bheaiprnvodm", "ftihvlsjayw", "agdub", "v",
				"ahlqydvnkgeju", "jkv", "bepnzdw", "ogjuhltpnmaire", "gojxtmraiqz", "sfhv", "pgmjzehnfxrbk", "msat",
				"aodegjbmt", "n", "fpanl", "ghylfn", "vzxysgwncmeb", "onyeabqimcrtwp", "dvcbqueixzfwgo",
				"lafgbztpmdnyws", "ydaixthclnjgkq", "mgyajwfieus", "jinvoyud", "xrb", "g", "ceivybxtljdzu",
				"ijrqzdegpxs", "gjw", "kczrpqbtwjulamv", "alrvb", "usftxanbdw", "hitvrca", "aybtr", "kbxpwivucnley",
				"tv", "lgpbaytvjdfeowx", "igmkqlnedjaxsc", "qlvwszxhbrfe", "bofcmzyvsg", "gc", "zojkdvixfbant",
				"cstlvhpkfrdwney", "nblsowtza", "zjqthpwfbgsae", "xqrvdfusnhcbwlj", "lmsgtn", "dvwyxbch",
				"jagbesnvwhkfxoc", "rs", "ocyph", "rgmfyvwbekxad", "ynov", "w", "xlizrsf", "lctpaxqizb", "tmovsbjxqeh",
				"aqcoslvfmkg", "odpqkzlrxh", "osyfzjwbthpamue", "atihkjxbcmdfu", "ocrjlfnug", "psjwqyeibu", "fgkjnmpc",
				"bkljzrc", "rfgwkp", "kygcnhdu", "zjmwei", "lctvhjrngafo", "ouvgm", "kmcrx", "y", "r", "anri",
				"gtlrnepusmjbwh", "rketigxb", "zompxictdrqhy", "nbcavygtpldwmsr", "fdjbo", "dokmrypczgnf",
				"gjidtncwouer", "gdclb", "pbehgj", "rmzgxscqolnh", "pgwyiu", "rozvjcekpgudl", "ngzjyotwepavc",
				"rexjomgdfblsu", "ihjsz", "uy", "ivmx", "fmewhrgsxj", "ftdbcxpaglunhj", "yxnatjghfbzd",
				"rnqbmdhtwzgpsoi", "kabsdq", "aifosqdtmlxprjy", "vzcnmyfu", "zcogsdvrpy", "maorzpfqus", "jmxrhfgtepqoz",
				"srkoghcuvewxfdz", "jvrfdtgihb", "ndg", "kxtqhg", "ftdlihv", "gklsuycht", "yxcv", "axsydfeg", "ayostk",
				"fhrwkb", "ezxauvsjfodit", "gdzxkbcowtyrnqp", "lxjraocfhi", "idge", "afptqjcvd", "rpdagkqows",
				"uvjregzl", "vaeknyjci", "ztuavj", "qtodpfaxslmc", "hxamecynpdq", "nlzwr", "owbzkhcqlnyd",
				"axsioeklpbcuyq", "xpczv", "aruicpsw", "ebolyfqshp", "tuyjgbqxkcnav", "mcnyewxfvsi", "izb", "w",
				"ybrfj", "yrpchjik", "erljaoiyfxpkght", "swjgimbzaqc", "aiq", "nstwhcabkd", "pyrnahv", "ckezagrnw",
				"bqrxjysckmzife", "cqeslp", "bpcxfwy", "z", "eqypbakhzsdj", "dijepvmtohsbg", "tokfxvnzrsl",
				"vnamdoblrqwfx", "udfmzj", "txornzeiykw", "qzgjeidfybavhpc", "bcnasehw", "doqlptju", "uciwskjzfpdtlr",
				"orcayhmvgzx", "wvyq", "uixyfapoznleb", "zsawrfun", "ifjcovxalpmbryk", "cdvajtmnyr", "d", "vyu",
				"vwcknlphbite", "xarzstglin", "adm", "ifpkuzhs", "hlfrkscuzimb", "kliwz", "trcqxlmy", "gidhkfcvmzab",
				"cjxyoszh", "bhunojsazwfxvi", "l", "mwqfzlsguaeoi", "fqdomyght", "j", "swtqiovuaphm", "unyjg", "ieyxp",
				"aolfrbg", "pyovktzmrjuie", "uew", "l", "npwisxm", "a", "rkexvymhaof", "yuipgq", "qzvnsx", "bwatpdu",
				"vthizgue", "eh", "oxubpyaqjmfsd", "zxlsftu", "dusl", "rpdsmljtcoaqveg", "jfgnilepzhc", "nz",
				"wftpvsijg", "larx", "ylv", "drptekxzainhybo", "kamdovjbsnizq", "igoaprsznvjfkwb", "jt", "gcpfi",
				"ihvkomuc", "qnbgcdxviwulke", "cxuhyvdkesprq", "lixvrwskot", "wngphsjztvx", "wv", "rcbsphoqijdtmv",
				"nhprx", "a", "m", "wctzuk", "fingedrwyjsbl", "kbyqad", "xtgbyqovckn", "xr", "ygaenxqc", "dnibrxzohft",
				"jy", "fbyxqadrewshu", "rvfcdtgmkypwai", "wr", "csotefgijw", "rabphzvwcndqil", "zk", "zwycqvaiubers",
				"pty", "qrgtk", "kagdqfo", "efharqwngoicds", "tmgyub", "fln", "paqesokun", "nilutckzejqxgdv", "xtuzogl",
				"htfzpqywla", "wsmo", "glbfvmjzs", "brsc", "ojcqrn", "yqsncexfjumzgo", "sunqiwjhvbtxokm", "hw", "gy",
				"m", "wfli", "eqazhgjvfydtusr", "bu", "lwu", "mnpobr", "xtv", "aysfkui", "vwmjgknbxheu", "ktabp",
				"yqjpfxwen", "podsig", "erqdbxgckiwlht", "emdbpfvzl", "gauhjcvxrtmd", "eykrotbig", "qfhwydcn",
				"njgtvwmzlk", "n", "urtnipf", "c", "ptdwigz", "qgvutfsrxp", "mczxv", "whayfszc", "wqcaskzb", "ox",
				"ngqpswbhd", "tabc", "lwtf", "lbukxpzacyevw", "tvsjzbaqohgwke", "qspcakoudj", "mho", "jdw",
				"situxhcgfnq", "vhopwt", "yqk", "pblx", "haxbyjvinrq", "gbiehqudwprjn", "hlg" };
		String[] targetWords = { "nsewcbujhad", "aeb", "phvbaeinctkwl", "cybwlsuzinvk", "qwhxytpvefrjz", "gvy",
				"ixcalbqfz", "igftodzvcnswjlm", "thbdfgivurj", "nbd", "dgqolunivxs", "bcsovemfldan", "unhzrsd",
				"skwlendhyucapzi", "zyrmohljp", "qum", "btmzgfqaspwjeh", "jgkmzqoyvtw", "tlgrawcxkn", "qdwogyrfs",
				"gephoxvsdj", "dfvxywjknm", "wru", "jnumkcfydo", "ewhbxfqgkclsj", "lz", "ghxopqbey", "xc",
				"jiznkxvcues", "uykrcxaofhm", "vmqdipal", "zjkmbqxtyefsicr", "fiawpvldc", "h", "dompynwi",
				"zbkynwmcxgves", "mxi", "ranoytupxb", "pyaqedhvzgjcbifl", "fy", "nrobdxvspqyjgui", "snrm",
				"gfyknowupqrta", "wivmt", "qtxyhcblrakfdg", "vfczbhtoa", "reho", "o", "rzn", "rabsgdfxij", "gpyhft",
				"jiv", "ufqji", "xe", "pnifxjhmtosa", "j", "vzodg", "cthzjspulafxiwb", "ohbmuqn", "rdliztsjukcwfpv",
				"saoqpd", "pxu", "kxnguybvejfwo", "fukagtlbndmpry", "sqlpaytnvhkrmo", "pm", "umco", "imjqrd", "riq",
				"vywxz", "npiu", "rvzjq", "qso", "epkloxmr", "racvl", "znkcwbg", "sfp", "mguztnorf", "pnjogwuyztacev",
				"qdyxcfzbhp", "bcwhdqzjultrai", "sfvheigw", "vgqb", "brsyjegvmhdc", "xwuadlp", "aft", "pinl", "gctwje",
				"ufjzmdp", "ohbxag", "cdfamgpntkwu", "ruaekpdbfqtzclj", "cesowgvpltxjihdr", "nfy", "jftgxplc",
				"zhlgtxou", "tljanzupriodew", "rlesyncqbkftuoh", "eqslt", "giotujnrwfdce", "qldztvnyguwxso",
				"vjkdfzuaseitxo", "rdimnopgzhlw", "ckrjyqwplitsfo", "dwvj", "wgje", "qcmrxk", "qgflbvxhn", "qoniymsa",
				"ftdcoxpqakigrejv", "hrusofb", "qcm", "scwykazqb", "riswegfoctj", "tq", "ekoc", "sjpkg", "dikj",
				"sqigfbrel", "eoknxfrup", "ot", "djfsbwkpuhl", "yvafsiku", "clnbxzg", "ivbhygjqrxan", "rit", "msprwq",
				"hfdjmckqzpulrw", "hfwazycos", "kdmnqztsi", "nrhol", "lctab", "svf", "crxngv", "gczkqjs", "agfqzhmy",
				"dvoxgmh", "ndvcuykgh", "vct", "nywvhcxbd", "e", "pbufvcszi", "ql", "agvpjizktbwsorfn", "zxvgbkwca",
				"omeayvfwhqzrpi", "fmgcxeutzdk", "ldpbcrayxztsjvw", "nxt", "ypluzeavsqw", "zmbv", "rucwispfa", "iucj",
				"jnhbzw", "vqhetubalnf", "poivetgflayxkjhr", "tje", "nr", "spygwiqr", "ewyuforkmpicnx", "vg", "hakjcn",
				"aygvphcszitqwku", "baovglc", "qmurcdzbhy", "wucgnfmlsjz", "kslongxrqhcmz", "pgfvquewxncalksb",
				"drqhje", "parmfuzhdkvb", "orfwcqbsv", "uoq", "iocesyphtzxvuwk", "oisafxherlpvjd", "xrbw", "iktsg",
				"dag", "ifpyer", "onerqivbwmjz", "ia", "kemzasyxndgjhoc", "ukvj", "celxkzuhwypbva", "y",
				"agejbtoqislvh", "xiopwdtfkba", "fqbihmywglxdnc", "cjmeizw", "ghzfqw", "eylv", "jbuylhnfk", "pkyfr",
				"rf", "dyvhipqjmgrezaf", "kcolxfmgnqvyz", "nphgbcujmo", "fqupgtrxvis", "f", "drishmtobjqcapv",
				"exutnvc", "pkzcqhmgnf", "ycgqbdtsenmlhf", "k", "wtgerl", "lqa", "ku", "i", "ydlzsgfirbjx", "owecuxrpm",
				"i", "ekr", "tglokjeyc", "ckmfij", "coxekquhwmd", "kfsdwcq", "hnpymjovxue", "twqyv", "demvwrtcsiabglq",
				"y", "kvnqszx", "g", "ewtuijhxyo", "mwhrsfxjgeb", "dwxfbntusoa", "lhiboak", "kune", "ow", "awzpn",
				"jqesgiuzrdpx", "rijvynudo", "ycvutdmgkroiexa", "qvo", "wupmsxni", "rcpnhx", "wsbcanhpe",
				"sdelrbyxqukzmw", "qhrygcuabnv", "fruaynbsedwqxh", "flyhcwnaoej", "ni", "rbtopmn", "jvtdensy", "few",
				"dn", "a", "chg", "h", "tiwdrbp", "tdm", "qghetodvsjimbp", "hymzfvgsobc", "kdqstyjznvhapb", "oem", "lb",
				"mhod", "adjhexcpqmny", "ljsiq", "whgdyxmzcs", "tc", "vyquexhzlwirbo", "gykq", "qhmjgo", "wmcrasnoxf",
				"xzrbwvpefnoj", "eyhaqspxvkrdcu", "ncbtsvzfr", "kwal", "slfyi", "fz", "nzbdmr", "akpdhycirg", "ofrbxuc",
				"ajkyobq", "tkxhd", "tjcxrw", "qiruxdljayvw", "xhvakznmibru", "shgizj", "mtgbuokycqjwz", "lbodjf",
				"xbgmzwslkup", "ix", "tefw", "szlqbfcrvewxh", "yugjdax", "aekjsruy", "womqkfdny", "jgzw", "lavbxr",
				"lijybwtshfva", "fwvlt", "abhvjc", "ub", "qew", "kwimvrfxsn", "mldvjhbsxkfqtp", "gfewmbh", "oe",
				"adurofqsiwcyek", "mrahvpzxqo", "gxtbcrjvnayquk", "agdukwhevqynjl", "fal", "jzrvwinkusldbot", "qnia",
				"kwhuiacrvobp", "ewmr", "rmwdsvtgp", "zctjunxidevybl", "ckuexlrgpn", "dh", "dczbrilvhnwpaqt",
				"ustilnpkfowzy", "bknrejhxopmgzf", "uzvteaj", "xnkie", "dxbtswmrekfvncu", "yeuaxkilbcshopq", "ax",
				"suchdoxfbn", "iegrpnd", "qetwovbjs", "kxrobvsuwzd", "suwj", "xsgdcavhoeyrznl", "fo", "vtpyhaowszmq",
				"hfwonijbvdzxsua", "onatjk", "sau", "dvbwoatyjsxpgefl", "na", "mglfynh", "ywlkdcbnx", "qwvojklutydran",
				"aql", "gdol", "m", "ufskachixjtmbd", "kxlwg", "klgmyuparhtox", "fvshdugarpyejqzt", "ejidg",
				"uknhpsfqdotvjya", "novyphxwj", "blxps", "d", "kc", "cnaroqj", "qu", "incfrutp", "ci", "dtugyziblrqh",
				"dsfoquxevlarht", "zwmnptjau", "ytecmgvjf", "maoictxvjus", "uwhxytnv", "tbmzpscehxkarwoi", "ztxv",
				"kigyjb", "frlapn", "wcveqlpj", "arz", "bfqkiatlmvsueo", "jkepaqwimx", "jefodwbt", "xcnqwdhtlkmiryp",
				"xulkbnq", "ot", "m", "jchodig", "wcqgmilbajzs", "zekqsxwgfdjyblc", "nmxavdocguybrtp", "bkyczmptogqiu",
				"mastzincjxqb", "nzm", "dxpfaoelg", "hygbrxamzcov", "b", "pkgvdzsrcyo", "whqopvdgexfntaz",
				"iowrnxkltsv", "f", "nvcuymzwf", "sxevmktrdyqpga", "ulwzsntvhgo", "fkvzgxbadmihc", "kmferiap",
				"gnpylhidxqvre", "zfunlhxpajsmte", "psomxbu", "tpyz", "vrbnpzicehqlk", "vut", "hmosw",
				"wrcoegynlmihktq", "ehujpgb", "teurhbpola", "te", "qmhvgazpy", "qn", "xgkevnmujhbcw", "cednjuyzfrk",
				"bl", "tvjsdkzgbfrnolx", "o", "jeszr", "lf", "pxmrstykena", "etkaqgywb", "xitepcoqmywnabr", "phfeo",
				"tuzkb", "ltcpynmzkhe", "qf", "jceaqor", "vikewzdsflayrh", "amipvtk", "bqjxfctm", "xyuflbwdni", "zjn",
				"avnyhxtgcbmsj", "fyxztlw", "rhiksqzwbncdu", "jnsgkmxz", "mbhfu", "unrqvayjeiocsld", "ugb", "iu",
				"orjyfb", "cfxyv", "dkrzslecipt", "rh", "otuwqevildhsfpbj", "lsxrizef", "ufwl", "vpbsgxlucam",
				"zldruejvg", "qdszvjpgh", "omqlsijg", "zrjsyimekutopv", "tqiwgkjxhp", "pmldfswutjenyo", "juzltnvkgwm",
				"istbrgxek", "zsekjfihrbmdgtl", "ntxlkarzsfvo", "tfzmsyn", "junvwaoiy", "iuehozgtv", "gwpfkry",
				"jyuwpvil", "zor", "mrxfkeiguqcy", "tlops", "jvratnwemgupsl", "ufvrzmts", "dpkjsfmthglwic",
				"bhkandtjwvgpr", "gbcmstwonrvj", "gnsxietuyvohjc", "np", "rpjyhckie", "tj", "fhoxkpinujs", "boq",
				"vlytmzbcj", "nboyucs", "f", "tmkrbvcequgolsi", "inthajrleycopd", "mzpkoteqjfhgxr", "wifjoezhqlaydrg",
				"dufr", "zsg", "rafzbmldtkc", "uamgpkrzet", "eajgftqzl", "ifkgbcwn", "mbgqnsrv", "thgewzbiufdp", "ng",
				"oszkxyeritnw", "npvryhas", "gqwpnlft", "gtbsreykoi", "ytcuaefbkwo", "whv", "indxwfc", "zqi",
				"snvihkaglfxp", "zjlefovgdby", "jlkwuacx", "jzkocbnaismqdv", "qxnz", "fehcipdbnv", "qwhpxnejfy",
				"lrnwjz", "jfduoehpxgs", "md", "dej", "erbipdhgnquwjc", "utyabgm", "mrghpwtnaiqkfc", "mlcoq",
				"smxavtwkeizo", "j", "anjwekzo", "gvsoqdbwnc", "ribnmhugpt", "zxqgtkh", "lh", "zvib", "ianrw",
				"ozekxhrdqpl", "gdns", "fxymzdjbthang", "vynmo", "segtfrnjzuvd", "h", "x", "qlfwdxjzna", "jmlrotpyhcuv",
				"zfwsqrgxk", "lmq", "qwdifkjecshung", "utdihflv", "mnuvsawckq", "ucakhswdtbn", "oaedpl", "rohtbfdxnzei",
				"cu", "vdlcw", "tsgudkwo", "ugijehftmalzv", "ehmkjblipgv", "n", "bd", "sgko", "neb", "qxbuingv",
				"fcvtpjadqz", "zqnrskbme", "ldgxwijqnkrfcp", "cnj", "lcqxgyena", "hufobzqekpxvldm", "ctxn", "ab",
				"aolvmzespbrnjg", "io", "kbhwspg", "jwhomcr", "npfl", "zidqsvpunjbyaxc", "bav", "tmwrjlsed",
				"jzibvwcstlgrk", "hizmbwqyge", "onyxbergpvjul", "o", "noigbrtqzhuwpsdm", "wgyoitnkacj",
				"cleatwzurifgdxoj", "ydprewfczknlt", "yjiemrltqhkfzd", "qbhe", "y", "uhgq", "a", "eptlxqmoairfyjds",
				"pytesjdvo", "ulajndfgx", "knvpfcmldwbios", "ejqxawcop", "c", "xhloesfqypb", "j", "yflgq", "vcyu",
				"chqztuvn", "vmwubperxk", "samxt", "po", "t", "exfdpatnwosk", "xcqonaptfmlsd", "tlmayecdkisrpbz",
				"hgyvzlbxetufjmw", "fsgakpcndiuzeb", "m", "luevtfj", "avguom", "afqwnblsomk", "qlozdybwcfnhk",
				"fosmbqua", "afdmrgsqwxvo", "lzdfjtbqc", "qhagb", "qeimns", "xnhrs", "xdtwiymhskqoa", "hfbgnwjuzevlkpr",
				"by", "ogtlerhvdmbi", "epcdgwajviourbx", "pdohxc", "oxqkbethrlwnpma", "pwdhq", "tkgnzbhverafc",
				"zlpbvitakqrf", "ynbfxwpc", "ygmxtiv", "ybtpaudw", "nagxrepfl", "rvp", "rhbiavct", "vmqspyzfuw", "ajex",
				"fgjrad", "zr", "wzk", "jk", "rkqzmjabip", "ditpyqoxwnzgja", "ybsnciveoakjlmq", "ywverqzmujginxc",
				"czvrm", "bazyusfmdtjgie", "yhmlbrtxskuwqa", "pnqgesyzuvwkt", "ahpntv", "kmgcndrfyzpoj", "zobskapmlj" };
		System.out.println(wordCount(startWords, targetWords));
	}

	public static int wordCount(String[] startWords, String[] targetWords) {

		Map<String, Integer> count = new HashMap<String, Integer>();
		for (int i = 0; i < targetWords.length; i++) {
			char[] c = targetWords[i].toCharArray();
			Arrays.sort(c);
			String tempo = new String(c);
			if (!count.containsKey(tempo)) {
				count.put(tempo, 1);
			} else {
				count.replace(tempo, count.get(tempo) + 1);
			}
		}
		int res = 0;
		for (int i = 0; i < startWords.length; i++) {
			int[] counter = new int[26];
			for (int k = 0; k < startWords[i].length(); k++) {
				counter[startWords[i].charAt(k) - 'a']++;
			}
			for (int j = 0; j < 26; j++) {
				if (!(counter[j] == 1)) {
					char[] c = (startWords[i] + (char) ('a' + j)).toCharArray();
					Arrays.sort(c);
					String tempo = new String(c);
					if (count.containsKey(tempo)) {
						res += count.get(tempo);
						count.remove(tempo);
					}
				}
			}
		}
		return res;
	}
}