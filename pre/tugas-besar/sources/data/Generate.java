package data;

import java.util.ArrayList;

import models.JurusanModel;
import models.PendidikanModel;
import models.ProgramStudiModel;
import models.RuanganModel;
import models.TahunAjaranModel;
import models.TahunMasukModel;
import models.TempatLahirModel;
import services.JurusanService;
import services.PendidikanService;
import services.ProgramStudiService;
import services.RuanganService;
import services.TahunAjaranService;
import services.TahunMasukService;
import services.TempatLahirService;

public class Generate {
	public static void start() {
		jurusan();
		pendidikan();
		tempatLahir();
		tahunAjaran();
		tahunMasuk();
		ruangan();
	}

	private static final ArrayList<JurusanModel> jurusan = new ArrayList<JurusanModel>();
	private static final ArrayList<ProgramStudiModel> programStudi = new ArrayList<ProgramStudiModel>();

	public static void jurusan() {
		final JurusanService jurusanService = new JurusanService();
		final ProgramStudiService programStudiService = new ProgramStudiService();

		int jurusanIndex = 0;
		int programStudiIndex = 0;
		for (Object[] jurusanRaw : Raw.getJurusan()) {
			jurusanIndex++;

			for (Object[] programStudiRaw : (Object[][]) jurusanRaw[2]) {
				programStudiIndex++;

				programStudi.add(
						new ProgramStudiModel(
								programStudiIndex,
								jurusanIndex,
								(String) programStudiRaw[0],
								(String) programStudiRaw[1]));
			}

			jurusan.add(new JurusanModel(
					jurusanIndex,
					(String) jurusanRaw[0],
					(String) jurusanRaw[1]));
		}

		jurusanService.clear();
		jurusanService.add(jurusan.toArray(new JurusanModel[0]));
		jurusanService.display();

		programStudiService.clear();
		programStudiService.add(programStudi.toArray(new ProgramStudiModel[0]));
		programStudiService.displayExtend();
	}

	private static final ArrayList<PendidikanModel> pendidikan = new ArrayList<PendidikanModel>();

	public static void pendidikan() {
		final PendidikanService pendidikanService = new PendidikanService();

		int pendidikanIndex = 0;
		for (String[] pendidikanRaw : Raw.getPendidikan()) {
			pendidikanIndex++;

			pendidikan.add(new PendidikanModel(
					pendidikanIndex,
					pendidikanRaw[0],
					pendidikanRaw[1]));
		}

		pendidikanService.clear();
		pendidikanService.add(pendidikan.toArray(new PendidikanModel[0]));
		pendidikanService.display();
	}

	private static final ArrayList<TempatLahirModel> tempatLahir = new ArrayList<TempatLahirModel>();

	public static void tempatLahir() {
		final TempatLahirService tempatLahirService = new TempatLahirService();

		int tempatLahirIndex = 0;
		for (String tempatLahirRaw : Raw.getTempatLahir()) {
			tempatLahirIndex++;

			tempatLahir.add(new TempatLahirModel(
					tempatLahirIndex,
					tempatLahirRaw));
		}

		tempatLahirService.clear();
		tempatLahirService.add(tempatLahir.toArray(new TempatLahirModel[0]));
		tempatLahirService.display();
	}

	private static final ArrayList<TahunAjaranModel> tahunAjaran = new ArrayList<TahunAjaranModel>();

	public static void tahunAjaran() {
		final TahunAjaranService tahunAjaranService = new TahunAjaranService();

		int tahunAjaranIndex = 0;
		for (String tahunAjaranRaw : Raw.getTahunAjaran()) {
			tahunAjaranIndex++;

			tahunAjaran.add(new TahunAjaranModel(
					tahunAjaranIndex,
					tahunAjaranRaw + " Ganjil"));

			tahunAjaran.add(new TahunAjaranModel(
					tahunAjaranIndex,
					tahunAjaranRaw + " Genap"));
		}

		tahunAjaranService.clear();
		tahunAjaranService.add(tahunAjaran.toArray(new TahunAjaranModel[0]));
		tahunAjaranService.display();
	}

	private static final ArrayList<TahunMasukModel> tahunMasuk = new ArrayList<TahunMasukModel>();

	public static void tahunMasuk() {
		final TahunMasukService tahunMasukService = new TahunMasukService();

		int tahunMasukIndex = 0;
		for (String tahunMasukRaw : Raw.getTahunMasuk()) {
			tahunMasukIndex++;

			tahunMasuk.add(new TahunMasukModel(
					tahunMasukIndex,
					tahunMasukRaw));
		}

		tahunMasukService.clear();
		tahunMasukService.add(tahunMasuk.toArray(new TahunMasukModel[0]));
		tahunMasukService.display();
	}

	private static final ArrayList<RuanganModel> ruangan = new ArrayList<RuanganModel>();

	public static void ruangan() {
		final RuanganService ruanganService = new RuanganService();

		int ruanganIndex = 0;
		for (String ruanganRaw : Raw.getRuangan()) {
			for (int firstIndex = 1; firstIndex <= 3; firstIndex++) {
				for (int thirdIndex = 1; thirdIndex <= 7; thirdIndex++) {
					ruanganIndex++;

					ruangan.add(new RuanganModel(
							ruanganIndex,
							ruanganRaw + firstIndex + "0" + thirdIndex));
				}
			}
		}

		ruanganService.clear();
		ruanganService.add(ruangan.toArray(new RuanganModel[0]));
		ruanganService.display();
	}

}
