package jnode.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author kreon
 * 
 */
@DatabaseTable(tableName = "links")
public class Link {
	@DatabaseField(columnName = "id", generatedId = true)
	private Long id;
	@DatabaseField(columnName = "station_name", canBeNull = false)
	private String linkName;
	@DatabaseField(columnName = "ftn_address", uniqueIndex = true, canBeNull = false)
	private String linkAddress;
	@DatabaseField(columnName = "pkt_password", defaultValue = "", canBeNull = false)
	private String paketPassword;
	@DatabaseField(columnName = "password", defaultValue = "-", canBeNull = false)
	private String protocolPassword;
	@DatabaseField(columnName = "address", defaultValue = "-", canBeNull = false)
	private String protocolAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getPaketPassword() {
		return paketPassword;
	}

	public void setPaketPassword(String paketPassword) {
		this.paketPassword = paketPassword;
	}

	public String getProtocolPassword() {
		return protocolPassword;
	}

	public void setProtocolPassword(String protocolPassword) {
		this.protocolPassword = protocolPassword;
	}

	public String getProtocolHost() {
		if (protocolAddress.equals("-")) {
			return "-";
		} else {
			String[] parts = protocolAddress.split(":");
			return parts[0];
		}
	}

	public void setProtocolHost(String protocolHost) {
		protocolAddress = protocolHost;
	}

	public Integer getProtocolPort() {
		if ("-".equals(protocolAddress)) {
			return 0;
		} else {
			String[] parts = protocolAddress.split(":");
			if (parts.length == 1) {
				return 24554; // TODO fix this ?
			}
			return Integer.valueOf(parts[parts.length - 1]);
		}
	}

	public void setProtocolPort(Integer protocolPort) {
		if (!"-".endsWith(protocolAddress)) {
			protocolAddress += ":" + protocolPort;
			if (protocolPort != 24554) {// TODO fix this ?
				protocolAddress = getLinkAddress() + ":" + protocolPort;
			}
		}
	}

	public String getProtocolAddress() {
		return protocolAddress;
	}

	public void setProtocolAddress(String protocolAddress) {
		this.protocolAddress = protocolAddress;
	}

    @Override
    public String toString() {
        return "Link [id=" + id + ", linkName=" + linkName + ", " +
                "linkAddress=" + linkAddress
                + ", protocolAddress=" + protocolAddress + "]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((linkAddress == null) ? 0 : linkAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
