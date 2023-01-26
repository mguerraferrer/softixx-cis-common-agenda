package mx.softixx.cis.common.agenda.payload;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NonWorkingDayResponse {
	private Long medicalScheduleId;
	
	@Getter(AccessLevel.NONE)
	private List<NwdResponse> nonWorkingDays;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class NwdResponse {
		private Long id;
		private LocalDate date;
		private Integer year;
		private Integer month;
		private Integer day;
	}

	public List<NwdResponse> getNonWorkingDays() {
		if (nonWorkingDays == null) {
			nonWorkingDays = new ArrayList<>();
		}
		return nonWorkingDays;
	}
}